package com.sbt.homework.classTask;

import java.util.concurrent.Callable;

public class Task<T> {
    volatile T result; // Все операции с этой переменной атомарные
    Callable<? extends T> callable;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (result == null) {
            synchronized (this) {
                if (result == null) {
                    try {
                        result = callable.call();
                        return result;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return result;
    }
}
