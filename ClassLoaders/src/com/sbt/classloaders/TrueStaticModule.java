package com.sbt.classloaders;

 public class TrueStaticModule {  // Нужен для того чтобы использовать загруженные модули
     protected static int counter= 0;
     public static int getCounter()
     {
         return counter;
     }
}