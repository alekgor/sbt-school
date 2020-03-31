package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

//Задание 1: Подсчитайте количество различных слов в файле.
public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> setOfString = new HashSet<>();
        try (Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/ww.txt"), "windows-1251")) {
            while (in.hasNext()) {
                try {
                    StringTokenizer st = new StringTokenizer(in.next());
                    setOfString.add(st.nextToken(" )(,-;\":.!?[]1234567890").toLowerCase());
                } catch (NoSuchElementException ignored) {
                }
            }
        }

        System.out.println(setOfString.size());
    }
}
