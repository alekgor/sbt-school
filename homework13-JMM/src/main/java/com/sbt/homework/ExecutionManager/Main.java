package com.sbt.homework.ExecutionManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runnable[] tasks = new Runnable[]{new SomeTask(),
                new SomeTask(),
                new SomeTask(),
                new SomeTask(),
                new SomeTask(),
        };

        ExecutionManager manager = new ExecutionManagerImp();
        Context context = manager.execute(() -> System.out.println("callback run"), tasks);
        System.out.println(context.getCompletedTaskCount());
        Thread.sleep(1000);

    }
}
