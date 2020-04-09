package com.sbt.homework;

public class Main {
    public static void main(String[] args) {
        ThreadPool tp = new FixedThreadPool(5);
        tp.start();
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
        tp.execute(new SomeTask());
    }
}
