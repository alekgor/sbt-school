package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
public class Task6 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>(5000);
        try (Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/ww.txt"), "windows-1251")) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        }
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNextLine()) {
            StringTokenizer st = new StringTokenizer(keyboard.nextLine());
            while (st.countTokens() != 0) {
                System.out.println(list.get(Integer.parseInt(st.nextToken())));
            }
        }
    }
}
