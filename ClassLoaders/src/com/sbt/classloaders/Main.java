package com.sbt.classloaders;

import java.util.Scanner;

public class Main {
    public static void print(Class class_) {
        System.out.println(class_.getName() + " :::: " + class_.getClassLoader());
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        ClassLoader loader = new DynamicClassOverloader(new String[]{"bin",".","out/production/ClassLoaders"});// Загружает .class из /bin
        while (true) {
//            Class testModuleClass = Class.forName("TestModule",true, loader); // Загружаем сами, загрузчик будет DynamicClassOverl..
            Class dynamicModuleClass = Class.forName("com.sbt.classloaders.DynamicModule",true, loader);//Загружаем сами из classpatha, загрузчик будет DynamicClassOverl..
            TrueStaticModule trueStaticModuleClass = (TrueStaticModule) dynamicModuleClass.newInstance();
            // TrueStaticInt загрузится с помощью SystemLoader => можно спокойно взаимодествовать с dynamicModule через него обходя CastExc


            print(dynamicModuleClass);      // Загрузили своим загрузчиком
            print(TrueStaticModule.class);  // Загрузили системным
            sc.nextLine();
        }
    }
}
//
//=== Загружен class com.sbt.classloaders.TestModule ===
//com.sbt.classloaders.TestModule, version 1!
//***Изменяем com.sbt.classloaders.TestModule.java и компилируем новый в bin/
//=== Загружен class com.sbt.classloaders.TestModule ===
//com.sbt.classloaders.TestModule, version 2!


