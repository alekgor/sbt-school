package com.sbt.homework.classTask;

import java.util.concurrent.Callable;

public class MyCall implements Callable<String> {

    @Override
    public String call() throws Exception {
//        throw new RuntimeException();
        return  "Ответ посчитал поток " + Thread.currentThread().getName();
    }
}
