package com.sbt.serialization;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxyInvocationHandler implements InvocationHandler {
    Object o;
    //  метод   имя+параметы результат
    Map<String, Object> cach; // Память jvm

    public CacheProxyInvocationHandler(Object o) {
        this.o = o;
        cach = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String keyOfMethod = method.getName() + Arrays.toString(args);

        if (cach.containsKey(keyOfMethod)) {
            Object res = cach.get(keyOfMethod);
            System.out.println("Кеш : " + keyOfMethod + " = " + res);
            return cach.get(keyOfMethod);
        } else {
            Object res = method.invoke(o, args);
            System.out.println("Счет: " + keyOfMethod + " = " + res);
            cach.put(keyOfMethod, res);
            return res;
        }
    }
}
