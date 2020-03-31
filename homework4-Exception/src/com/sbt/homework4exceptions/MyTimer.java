package com.sbt.homework4exceptions;

public class MyTimer {
    Long time = (long)1;

    public void start() {
        time = System.currentTimeMillis();
    }

    public Boolean lock() {
        double d = 30 - (double) (System.currentTimeMillis() - time) / 1000;

        d = d < 0 ? 0 : d;
        return d != 0;
    }

    public Integer secondsLeft(){
        int d = 30 - (int) (System.currentTimeMillis() - time) / 1000;
        d = Math.max(d, 0);
        return d;
    }
}
