package com.sbt.homework;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPool tp = new FixedThreadPool(5);
//        tp.start();
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
//        tp.execute(new SomeTask());
        System.out.println("Кол-во потоков до создания PullThreada = " + Thread.activeCount());
        ThreadPool stp = new ScalableThreadPool(1,4);
        stp.start();
        stp.execute(new SomeTask());
        stp.execute(new SomeTask());
        stp.execute(new SomeTask());
        stp.execute(new SomeTask());
        TimeUnit.SECONDS.sleep(20);
        System.out.println("Кол-во потоков после того как PullThred отработал(Должно быть cтарое значение потоков + minBound) = " + Thread.activeCount());
//        stp.execute(new SomeTask());
//        stp.execute(new SomeTask());
//        stp.execute(new SomeTask());
//        stp.execute(new SomeTask());


    }
}
