package com.sbt.classloaders;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void print(Class class_) {
        System.out.println(class_.getName() + " :::: " + class_.getClassLoader());
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            ClassLoader loader = new DynamicClassOverloader(new String[]{"bin","."});
            Class testModuleClass = Class.forName("TestModule",true, loader);
            Object obj = testModuleClass.newInstance();
            System.out.println(obj);
            sc.nextLine();
        }
    }
}
//
//=== Загружен class TestModule ===
//TestModule, version 1!
//***Изменяем TestModule.java и компилируем новый в bin/
//=== Загружен class TestModule ===
//TestModule, version 2!


