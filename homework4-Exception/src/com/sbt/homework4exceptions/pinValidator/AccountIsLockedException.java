package com.sbt.homework4exceptions.pinValidator;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
