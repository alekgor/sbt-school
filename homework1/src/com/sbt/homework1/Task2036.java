package com.sbt.homework1;

import java.util.Scanner;

public class Task2036 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[100];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }
        in.close();

        String temp = "eyuioa";
        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean flag = true;
            String st = arr[i];
            for (int j = 0; j < st.length(); j++) {
                if (temp.contains(st.substring(j, j + 1))) {
                    count++;
                } else {
                    count = 0;
                }
                if (count > 2) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(st);
            }
        }
    }
}
