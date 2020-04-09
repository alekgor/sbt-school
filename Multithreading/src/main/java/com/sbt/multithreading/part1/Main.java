package com.sbt.multithreading.part1;

public class Main {


    public static void main(String[] args) throws InterruptedException {
//        new Thread(new SomeTaskImplementsRunnable()).start();
//        new SomeTaskExtendsThread().start();

//
//        Thread t = new Thread(new SomeTaskImplementsRunnable());
//        t.setDaemon(true);
//        t.start();
//        t.join(10);

//        Thread t = new Thread(new SomeTaskImplementsRunnable())
//        // Установим обработчик на Конкретный поток
//        t.setUncaughtExceptionHandler((t1, e) -> System.out.printf("Exception %s has been catch from thread %s", e, t1.getName())); // Наш обработчик
//        t.start();

        Thread t = new Thread(new SomeTaskImplementsRunnable());
        // Установим обработчик на все потоки
        Thread.setDefaultUncaughtExceptionHandler((t1, e) -> System.out.printf("Exception %s has been catch from thread %s", e, t1.getName()));
        t.start();
    }
}
