package com.sbt.homework.ExecutionManager;

public class ExecutionManagerImp implements ExecutionManager {
    volatile ContextImpl context;

    @Override
    public Context execute(Runnable callback, Runnable[] tasks) {
        this.context = new ContextImpl();
        FixedThreadPool threadPool = new FixedThreadPool(5,this.context, tasks);
        threadPool.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadPool) {
                    System.out.println("");
                    try {
                        threadPool.wait();
                        callback.run();
                        threadPool.shutDown();
                        Thread.currentThread().interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return this.context;
    }
}
