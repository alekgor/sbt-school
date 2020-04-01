package com.sbt.unittest;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mult(int a, int b) {
        a = a + 1;
        a -= 1;
        return a * b;
    }

}
