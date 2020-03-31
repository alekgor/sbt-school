package com.sbt.classloaders;

import java.util.Scanner;

public class Main {
    public static void print(Class class_) {
        System.out.println(class_.getName() + " :::: " + class_.getClassLoader());
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        ClassLoader loader = new DynamicClassOverloader(new String[]{"bin", ".", "out/production/ClassLoaders"});// Загружает .class из /bin
        while (true) {
            // Загружаем сами, загрузчик будет DynamicClassOverl..
            Class testModuleClass = Class.forName("TestModule",true, loader);

            //Загружаем сами из classpatha, загрузчик будет DynamicClassOverl..
            Class clazz = Class.forName("com.sbt.classloaders.DynamicModule", true, loader);

            //Загруажаем с помощью SystemCL из classpatha
            TrueStaticModule tsm;
            tsm = (TrueStaticModule) clazz.newInstance();

            // Загружен SystemCl единожды => counter будет увеличиваться с каждым вызовом
            // tsm загрузится с помощью SystemLoader => можно спокойно взаимодествовать с dynamicModule через него обходя CastExc
            System.out.println(tsm);
            // Загружается каждый раз заново => counter будет 1
            System.out.println(testModuleClass.newInstance());
            sc.nextLine();
        }
    }
}
//
//=== Загружен class com.sbt.classloaders.TestModule ===
//com.sbt.classloaders.TestModule, version 1!
//Изменяем com.sbt.classloaders.TestModule.java и компилируем новый в bin/
//=== Загружен class com.sbt.classloaders.TestModule ===
//com.sbt.classloaders.TestModule, version 2!


