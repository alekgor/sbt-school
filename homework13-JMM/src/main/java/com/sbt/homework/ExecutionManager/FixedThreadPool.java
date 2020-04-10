package com.sbt.homework.ExecutionManager;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;


public class FixedThreadPool implements ThreadPool {
    private ArrayDeque<Runnable> queueTask;
    private LinkedList<Thread> threads;
    private volatile int waitingThreads;
    private volatile int countThreads;
    private volatile ContextImpl context;

    public FixedThreadPool(int threadCount, ContextImpl context, Runnable... tasks) {
        synchronized (this) {
            this.context = context;
            this.countThreads = threadCount;
            threads = new LinkedList<>();
            queueTask = new ArrayDeque<>();
            queueTask.addAll(Arrays.asList(tasks));
            for (int i = 0; i < countThreads; i++) {
                threads.add(new Thread(FixedThreadPool.this::run));
            }
        }
    }

    @Override
    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (this) {
            queueTask.add(runnable);
            this.notify();
        }
    }

    public void shutDown() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }


    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable r;
                synchronized (this) {
                    while (queueTask.isEmpty()) {
                        waitingThreads++;
                        if (waitingThreads == countThreads) {    // Если заданий больше нет и все потоки ждут, то кидаем notify в ExManager,
                            this.notify();                       // чтобы остановить тредпул
                        }
                        this.wait();
                    }
                    r = queueTask.pop();
                }
                System.out.println(Thread.currentThread().getName() + ":: SomeTask старт");
                try {
                    r.run();
                } catch (Exception e) {
                    context.failedTaskCount++;
                    context.completedTaskCount--;
                }
                context.completedTaskCount++;
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " остановлен");
            }
        }
    }
}
