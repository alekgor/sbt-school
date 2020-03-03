package com.sbt.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2021 {

    public static int getMax(Integer n, int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstString = new StringTokenizer(in.readLine());
        StringTokenizer secondString = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(firstString.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondString.nextToken());
        }
        int max = getMax(n, arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                arr[i] = max / 2;
            }
        }
        max = getMax(n, arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                arr[i] = max / 2;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
