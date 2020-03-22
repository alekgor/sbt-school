package com.sbt.reflection;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void printData(Object myClass) {
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        MyClass myClass = new MyClass(1,"default");
        int number = myClass.getNumber();
        String name = null;
        System.out.println(number + name);
        try {
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myClass);
            field.set(myClass,"Alex");
            name = (String) field.get(myClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(number + name);

        myClass = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());
            Class[] params = {int.class,String.class};
            myClass = (MyClass) clazz.getConstructor(params).newInstance(1,"default2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);


        try {
            Class clazz = Class.forName(MyClass.class.getName());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor: constructors) {
                Class[] params = constructor.getParameterTypes();
                for (Class paramType: params) {
                    System.out.print(paramType.getName()+" ");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
