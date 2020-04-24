package com.sbt;

public class Task implements Runnable {

    public void run() {
        System.out.println("Working..." + Thread.currentThread().getName());
    }
}
