package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task3 {

    public static void main(String[] args) throws FileNotFoundException {

//      Реализация с помощью HashMap
        Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/text.txt"));
        HashMap<String, Integer> hashMap = new HashMap<>(150);
        while (in.hasNext()) {
            StringTokenizer st = new StringTokenizer(in.next());
            String key = st.nextToken(" )(,-«»;:.[]1234567890").toLowerCase();
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.computeIfPresent(key, (k, v) -> v + 1);
            }
        }
        in.close();
    }
}
