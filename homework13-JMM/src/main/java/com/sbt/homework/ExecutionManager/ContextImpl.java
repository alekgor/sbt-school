package com.sbt.homework.ExecutionManager;

public class ContextImpl implements Context {

    int completedTaskCount = 0;
    int failedTaskCount = 0;
    int interruptedTaskCount = 0 ;

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
