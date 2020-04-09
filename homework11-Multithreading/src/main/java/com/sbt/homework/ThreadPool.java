package com.sbt.homework;

public interface ThreadPool {
    void start();

    void shutDown();

    void execute(Runnable runnable);
}
