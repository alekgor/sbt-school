package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2013 {
    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstString = new StringTokenizer(in.readLine());
        StringTokenizer secondString = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(firstString.nextToken());

        int min = Integer.parseInt(secondString.nextToken());
        int count = 1;
        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(secondString.nextToken());
            if (min > x) {
                min = x;
                count = 1;
            } else if (min == x) {
                count++;
            }
        }
        System.out.println(count);
    }
}
