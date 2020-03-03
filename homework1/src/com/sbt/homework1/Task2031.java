package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2031 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstString = new StringTokenizer(in.readLine());
        StringTokenizer secondString = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(firstString.nextToken());
        int[] arr = new int[n];
        int[] map = new int[101];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondString.nextToken());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map[arr[i]] == 1) {
                count++;
            }
            map[arr[i]]++;
        }
        System.out.println(count);
        for (int i = 1; i <= 100; i++) {
            if (map[i] > 1) {
                System.out.print(i+" ");
            }
        }
    }
}
