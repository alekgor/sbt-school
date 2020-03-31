package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

//Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
public class Task3 {

    public static void main(String[] args) throws FileNotFoundException {

//      Реализация с помощью HashMap
        HashMap<String, Integer> hashMap = new HashMap<>(150);
        try (Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/ww.txt"), "windows-1251")) {
            while (in.hasNext()) {

                StringTokenizer st = new StringTokenizer(in.next());
                try {
                    String key = st.nextToken(" )(,-;\":.!?[]1234567890").toLowerCase();
                    if (!hashMap.containsKey(key)) {
                        hashMap.put(key, 1);
                    } else {
                        hashMap.computeIfPresent(key, (k, v) -> v + 1);
                    }
                } catch (NoSuchElementException ignored) {
                }
            }
        }
        hashMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
