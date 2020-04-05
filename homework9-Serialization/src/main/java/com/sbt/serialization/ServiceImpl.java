package com.sbt.serialization;

public class ServiceImpl implements Service {

    @Override
    public int sum(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return a + b;
    }

    @Override
    public String concat(String item1, String item2) throws InterruptedException {
        Thread.sleep(1000);
        return item1.concat(item2);
    }
}
