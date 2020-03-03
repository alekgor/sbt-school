package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2004 {
    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(in.readLine());
        if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}