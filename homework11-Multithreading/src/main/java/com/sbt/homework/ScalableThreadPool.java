package com.sbt.homework;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class ScalableThreadPool implements ThreadPool {
    private int minBound;
    private int maxBound;
    private volatile int countThreads;      // Потоков в данный момент
    private volatile int waitingThreads;       // Занятые потоки
    private ArrayDeque<Runnable> queueTasks;
    private LinkedList<Thread> threads;


    public ScalableThreadPool(int minBound, int maxBound) {
        this.minBound = minBound;
        this.maxBound = maxBound;
        this.countThreads = minBound;
        this.waitingThreads = 0;
        queueTasks = new ArrayDeque<>();
        threads = new LinkedList<>();
        for (int i = 0; i < minBound; i++) {
            threads.add(new Thread(ScalableThreadPool.this::run));
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
    public void shutDown() {
        threads.forEach(Thread::interrupt);
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (this) {
            queueTasks.add(runnable);
            this.notify();
        }
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable r;
                synchronized (this) {
                    while (queueTasks.isEmpty()) {
                        if (countThreads > minBound) { // Если нет задач, и потоков больше minBound то удаляем лишние
                            interruptThread();
                            countThreads--;
                        }
                        // System.out.println(Thread.currentThread().getName() + ":: Ждет");
                        waitingThreads++;
                        this.wait();
                        waitingThreads--;
                    }
                    r = queueTasks.pop();
                    // Если все потоки заняты, создаем новый поток  вставляем в конец
                    if (waitingThreads == 0 && !queueTasks.isEmpty() && countThreads < maxBound) {
                        createAndStartThread();
                        countThreads++;
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":: SomeTask старт");
                r.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }


    private void createAndStartThread() {
        Thread newThread = new Thread(ScalableThreadPool.this::run);
        threads.addFirst(newThread);
        System.out.println("Создался доп поток " + newThread.getName());
        newThread.start();
    }

    private void interruptThread() {
        Thread t = threads.pop();
        System.out.println("Удаляется доп поток " + t);
        t.interrupt();
    }
}
