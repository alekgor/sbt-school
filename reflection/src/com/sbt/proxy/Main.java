package com.sbt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MyBox box = new MyBox();
        box.setSize(5);

        IBox proxy = (IBox) Proxy.newProxyInstance(MyBox.class.getClassLoader(),
                MyBox.class.getInterfaces(),
                new MyInvocationHandler(box)); // Привязываем Proxy К box. Теперь при вызове люого метода через proxy, будет печататься его имя
        proxy.setSize(10);
        System.out.println(box.size);
        System.out.println("p:"+proxy.getSize());
        proxy.print();
    }
}




