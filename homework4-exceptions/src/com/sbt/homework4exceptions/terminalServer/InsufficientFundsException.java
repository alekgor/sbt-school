package com.sbt.homework4exceptions.terminalServer;

public class InsufficientFundsException extends ServerException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
