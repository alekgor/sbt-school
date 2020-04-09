package com.sbt.multithreading.part1;

public class SomeTaskImplementsRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " Priority: " + Thread.currentThread().getPriority());
                throw new RuntimeException();
            }
        } finally {
            System.out.println("Thread has done.");
        }

    }
}
