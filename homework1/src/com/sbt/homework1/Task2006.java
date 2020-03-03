package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2006 {
    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int countOfD = (n % 3 == 2) ? n / 3 + 1 : n / 3;
        int a = countOfD / 12;
        int b = countOfD % 12;
        System.out.println(a + " " + b);
    }
}
