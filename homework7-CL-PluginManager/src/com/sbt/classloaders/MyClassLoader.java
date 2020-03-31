package com.sbt.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    private final String rootDirectory;
    private final String pluginName;

    public MyClassLoader(String rootDirectory,String pluginName) {
        this.rootDirectory = rootDirectory;
        this.pluginName = pluginName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File f = findFile(rootDirectory,name);
        if (f == null){
            throw new ClassNotFoundException();
        }

        byte[] b = loadByteOfClass(f);
        return defineClass(name, b, 0, b.length);
    }


    private File findFile(String rootDirectory, String name) {
        File f = new File(new File("").getAbsolutePath() + File.separatorChar
                + rootDirectory + File.separatorChar + pluginName + File.separatorChar + name + ".class");
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

    private byte[] loadByteOfClass(File f) {
        byte[] b = new byte[(int)f.length()];
        try {
            try (FileInputStream st = new FileInputStream(f)) {
                st.read(b,0,b.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
