package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2008 {
    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(data.nextToken());
        int w = Integer.parseInt(data.nextToken());

        StringTokenizer a = new StringTokenizer(in.readLine());
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a.nextToken());
            if (sum + x <= w) {
                sum += x;
                count++;
            }
        }
        System.out.println(count + " " + sum);
    }
}
