package com.sbt.serialization;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class CacheProxyInvocationHandler implements InvocationHandler {
    Object o;
    String dirName;
    Map<String, DataCache<String, Object>> cacheMap;
//    DataCache<String, Object> fileCach;     // Содержит в себе данные из файла. Считывает и записывает в файл
//    DataCache<String, Object> memoryCach;   // После завершения программы исчезает


    public CacheProxyInvocationHandler(Object o, String dirName) {
        this.o = o;
        this.dirName = dirName;
        cacheMap = new DataCache<>();
//        fileCach = getDataCache(new File(dirName + "/" + o.getClass().getSimpleName()));
//        memoryCach = new DataCache<>();
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
        DataCache<String, Object> cache;
        if (an.type() == CacheType.FILE) {
            cache = getDataCache(new File(dirName + "/" + method.getName()));
        } else {
            cache = cacheMap.get(method.getName());
        }
        if (cache == null) {
            cache = new DataCache<>();
            cacheMap.put(method.getName(), cache);
        }


        Object res;
        if (cache.containsKey(keyOfMethod)) {
            res = cache.get(keyOfMethod);
            System.out.println("Кеш : " + keyOfMethod + " = " + res);
            saveInFile(an, new File(dirName + "/" + method.getName()), cache);
        } else {
            res = method.invoke(o, args);
            System.out.println("Счет: " + keyOfMethod + " = " + res);

            cache.put(keyOfMethod, res);
            saveInFile(an, new File(dirName + "/" + method.getName()), cache);
        }
        return res;
    }

    private DataCache<String, Object> getDataCache(File dataCacheFile) {
        File f = Serializer.unZIP(new File(dataCacheFile.getPath() + ".zip"));
        if (f != null) {
            return (DataCache<String, Object>) Serializer.deserialize(f);
        }
        DataCache<String, Object> res = (DataCache<String, Object>) Serializer.deserialize(dataCacheFile);
        return res;
    }

    // Сохраняет кеш в файл исходя из параметров аннотации
    private void saveInFile(Cache annotation, File file, Object obj) throws IOException {
        if (annotation.type() == CacheType.FILE) {
            new File(dirName + "/").mkdir();
            Serializer.serialize(file, obj);
            if (annotation.zip()) {
                Serializer.toZIP(file);
            }
        }
    }
}
