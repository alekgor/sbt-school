package com.sbt.classloaders;

 public class TrueStaticModule {  // Нужен для того чтобы использовать загруженные модули
    int counter = 0;
    public int getCounter() {
        return counter;
    }
}