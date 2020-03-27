package com.sbt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class MyInvocationHandler implements InvocationHandler { // Перевод исполнением метода, будет выводить название метода
    Object o;

    public MyInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("call : " + method.getName());
        return method.invoke(o,args);
    }
}