package com.sbt.serialization;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class CacheProxy {

    public CacheProxy() {
    }

    @SuppressWarnings("unchecked")
    public <T> T cache(T t, String dirName) {
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new CacheProxyInvocationHandler(t, dirName));
        return (T) o;
    }
}
