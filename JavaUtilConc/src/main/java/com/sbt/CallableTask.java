package com.sbt;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    public String call() throws Exception {
        return "WorkingCall " + Thread.currentThread().getName();
    }
}
