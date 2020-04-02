package com.sbt.serialization;

import java.lang.reflect.Proxy;

public class CacheProxy {

    public CacheProxy() {
    }

    public <T> T cache(T t) {
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new CacheProxyInvocationHandler(t));
        return (T) o;
    }
}
