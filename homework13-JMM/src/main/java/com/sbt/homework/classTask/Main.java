package com.sbt.homework.classTask;

public class Main {

    public static void main(String[] args) throws Exception {
        Task<String> task = new Task<>(new MyCall());
        Thread.setDefaultUncaughtExceptionHandler((t1, e) -> System.out.println(t1 + e.getMessage()));
        Thread thread = new Thread(task::get);
        thread.start();
        Thread.sleep(1000);
        // Вызываем результат из потока main
        System.out.println(task.get());
        // Видим, что задачу посчитал другой поток: Ответ посчитал поток Thread-0

    }
}
