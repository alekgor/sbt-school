package com.sbt.homework4exceptions.terminalServer;

public class ServerException extends Exception {
    public ServerException(String message) {
        super("Исключение от сервера: "+message);
    }
}
