package com.sbt.homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {

    public static final Comparator<String> myLenComp = (o1, o2) -> {
        if (o1.equals(o2)) {
            return 0;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 1;
        }
    };

    public static final Comparator<String> myLetComp = String::compareTo;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("src/com/sbt/homework2/text.txt"));
        HashSet<String> setOfString = new HashSet<>();
        while (in.hasNext()) {
            StringTokenizer st = new StringTokenizer(in.next());
            setOfString.add(st.nextToken(" )(,-«»;:.[]1234567890").toLowerCase());
        }
        in.close();

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
