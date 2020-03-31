package com.sbt.homework4exceptions.pinValidator;

public class NonCorrectPinException extends Exception {
    public NonCorrectPinException() {
        super("Некорректный PIN. Он должен состоять из 4х цифр.");
    }

    public NonCorrectPinException(String message) {
        super(message);
    }
}
