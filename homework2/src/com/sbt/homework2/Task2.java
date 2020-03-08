package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
// (компаратор сначала по длине слова, потом по тексту).
public class Task2 {

    public static final Comparator<String> myLenComp = Comparator.comparingInt(String::length);

    public static final Comparator<String> myLetComp = String::compareTo;

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

//      Sort by len
            ArrayList<String> sortedListOfWords = new ArrayList<>(setOfString);
            sortedListOfWords.sort(myLenComp);
            System.out.println("\n Сортировка по длине: ");
            for (String word : sortedListOfWords) {
                System.out.println(word);
            }

//      Sort by letter
            System.out.println("\n Сортировка по буквам:");
            sortedListOfWords.sort(myLetComp);
            for (String word : sortedListOfWords) {
                System.out.println(word);
            }
        }
    }
}
