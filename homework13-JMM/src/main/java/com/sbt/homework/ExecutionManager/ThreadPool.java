package com.sbt.homework.ExecutionManager;

public interface ThreadPool {
    void start();

    void shutDown();

    void execute(Runnable runnable);
}
