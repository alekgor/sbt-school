package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2011 {
    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(data.nextToken());

        if (n < 7) {
            System.out.println("preschool child");
        } else if (n <= 17) {
            int m = n - 6;
            System.out.println("schoolchild " + m);
        } else if (n <= 22) {
            int m = n - 17;
            System.out.println("student " + m);
        } else if (n <= 150) {
            System.out.println("specialist");
        }
    }
}
