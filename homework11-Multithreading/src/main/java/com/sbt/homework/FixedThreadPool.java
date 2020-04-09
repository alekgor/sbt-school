package com.sbt.homework;

import java.util.ArrayDeque;
import java.util.LinkedList;


public class FixedThreadPool implements ThreadPool, Runnable {
    private ArrayDeque<Runnable> queueTask;
    private LinkedList<Thread> threads;

    public FixedThreadPool(int threadCount) {
        threads = new LinkedList<>();
        queueTask = new ArrayDeque<>();
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(this));
        }
    }

    @Override
    public void start() {
        for (Thread t : threads) {
            System.out.println(t.getName() + ":: Запуск");
            t.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (this) {
            queueTask.add(runnable);
//            System.out.println(Thread.currentThread().getName() + " notify");
            this.notify();
        }
    }

    public void shutDown() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable r;
                synchronized (this) {
                    while (queueTask.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + ":: Ждет");
                        this.wait();
                    }
                    r = queueTask.pop();
                }
                System.out.println(Thread.currentThread().getName() + ":: SomeTask старт");
                r.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
