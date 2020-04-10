package com.sbt.homework.ExecutionManager;

public class SomeTask implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 5000000; i++) {
            sum += Math.tan(i);
        }
        System.out.println(Thread.currentThread().getName() + ":: SomeTask завершен Результат: " + sum);
    }
}
