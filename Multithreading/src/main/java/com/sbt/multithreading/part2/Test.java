package com.sbt.multithreading.part2;

import java.util.concurrent.TimeUnit;

public class Test implements Runnable {
//    private volatile boolean endFlag = false;
//
//    public void end() {
//        System.out.println("Call end:" + Thread.currentThread().getName());
//        endFlag = true;
//    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Tik from "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " finished...");
            }
        }
    }
}
