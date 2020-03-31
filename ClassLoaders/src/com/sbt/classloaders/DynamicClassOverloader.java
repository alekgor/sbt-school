package com.sbt.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


public class DynamicClassOverloader extends ClassLoader {
    private Map<String, Class> classesHash = new java.util.HashMap<>();
    public final String[] classPath;

    public DynamicClassOverloader(String[] classPath) {
        this.classPath = classPath;
    }

    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve)
            resolveClass(result);
        return result;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class result = classesHash.get(name);
        if (result != null) {
            // Метод forName кеширует классы, поэтому classesHash пригодится
            // если классы будут загружены через ClassLoader.loadClass(String name)
            System.out.println("% Class " + name + " found in cache");
            return result;
        }
        if (name.toLowerCase().contains("truestatic"))
            return findSystemClass(name);
        File f = findFile(name.replace('.', '/'), ".class");

        if (f == null) { // Если файла нет, то дилигируем задачу истемному загрузчику
            return findSystemClass(name);
        }

        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0,
                    classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(
                    "Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException(
                    "Format of class file incorrect for class "
                            + name + " : " + e);
        }
        classesHash.put(name, result);
        System.out.println("=== Загружен " + result + " ===");
        return result;
    }

    private File findFile(String name, String extension) {
        File f1;
        for (String s : classPath) {
            f1 = new File(new File(s).getPath()
                    + File.separatorChar
                    + name.replace('/', File.separatorChar)
                    + extension);
//            System.out.println("Поиск: " + f1.getAbsolutePath());
            if (f1.exists()) {
                return f1;
            }
        }
        return null;
    }


    public static byte[] loadFileAsBytes(File file)
            throws IOException {
        byte[] result = new byte[(int) file.length()];
        try (FileInputStream f = new FileInputStream(file)) {
            f.read(result, 0, result.length);
        }
        return result;
    }


}
