package com.sbt.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> ints = new ArrayList<>();
        ints = random.ints(0, 100).limit(100).boxed().collect(Collectors.toList());

        Streams<Integer> streams = Streams.of(ints);
        streams.filter(x -> x < 50).transform(Object::toString).list.forEach(System.out::println);

    }
}


