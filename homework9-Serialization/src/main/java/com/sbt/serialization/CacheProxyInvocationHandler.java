package com.sbt.serialization;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CacheProxyInvocationHandler implements InvocationHandler {
    Object o;
    String dirName;
    DataCache<String, Object> fileCach;     // Содержит в себе данные из файла. Считывает и записывает в файл
    DataCache<String, Object> memoryCach;   // После завершения программы исчезает


    public CacheProxyInvocationHandler(Object o, String dirName) {
        this.o = o;
        this.dirName = dirName;
        fileCach = getDataCache(new File(dirName + "/" + o.getClass().getSimpleName()));
        memoryCach = new DataCache<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String keyOfMethod = method.getName() + Arrays.toString(args);

        System.out.print("@Cache:" + method.isAnnotationPresent(Cache.class) + " ");

        if (!method.isAnnotationPresent(Cache.class)) {
            Object res = method.invoke(o, args);
            System.out.println("Счет: " + keyOfMethod + " = " + res);
            return res;
        }

        Cache an = method.getAnnotation(Cache.class);

        DataCache<String, Object> cach = fileCach;
        if (an.type() == CacheType.IN_MEMORY) cach = memoryCach;


        Object res;
        if (cach.containsKey(keyOfMethod)) {
            res = cach.get(keyOfMethod);
            System.out.println("Кеш : " + keyOfMethod + " = " + res);
        } else {
            res = method.invoke(o, args);
            System.out.println("Счет: " + keyOfMethod + " = " + res);

            cach.put(keyOfMethod, res);
            saveInFile(an);
        }
        return res;
    }

    private DataCache<String, Object> getDataCache(File dataCacheFile) {
        File f = Serializer.unZIP(new File(dataCacheFile.getPath() + ".zip"));
        if (f != null) {
            return (DataCache<String, Object>) Serializer.deserialize(f);
        }
        DataCache<String, Object> res = (DataCache<String, Object>) Serializer.deserialize(dataCacheFile);
        return (res != null ? res : new DataCache<>());
    }

    // Сохраняет кеш в файл исходя из параметров аннотации
    private void saveInFile(Cache annotation) throws IOException {
        if (annotation.type() == CacheType.FILE) {
            Serializer.serialize(new File(dirName + "/"), o.getClass().getSimpleName(), fileCach);
            if (annotation.zip()) {
                Serializer.toZIP(new File(dirName + "/" + o.getClass().getSimpleName()));
            }
        }
    }
}
