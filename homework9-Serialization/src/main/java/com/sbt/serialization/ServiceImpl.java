package com.sbt.serialization;

import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service {
    @Override
    public List<String> run(String item, double value, Date date) {
        return null;
    }

    @Override
    public int sum(int a, int b) throws InterruptedException {
//        System.out.println("Service working ...");
        Thread.sleep(5000);
//        System.out.println("Service finished...");
        return a + b;
    }

    @Override
    public String concat(String item1, String item2) throws InterruptedException {
        Thread.sleep(5000);
        return item1.concat(item2);
    }
}
