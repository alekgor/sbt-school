package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/text.txt"));
        HashSet<String> setOfString = new HashSet<>();
        while (in.hasNext()){
            StringTokenizer st = new StringTokenizer(in.next());
            setOfString.add(st.nextToken(" )(,-;:.[]1234567890").toLowerCase());
        }
        in.close();

        System.out.println(setOfString.size());
    }
}
