package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> list = new LinkedList<>();
        try (Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/ww.txt"), "windows-1251")) {
            while (in.hasNextLine()){
                list.add(in.nextLine());
            }
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}
