package com.sbt;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;

public class Student implements Serializable, ObjectInputValidation {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if ((name.length() < 10) )
            throw new InvalidObjectException("Invalid name");
    }
}
