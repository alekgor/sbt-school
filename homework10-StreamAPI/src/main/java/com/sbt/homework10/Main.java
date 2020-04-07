package com.sbt.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> ints = random.ints(0, 100).limit(100).boxed().collect(Collectors.toList());
        Streams.of(ints).filter(x -> x < 50).transform(Object::toString).forEachPrint();

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alex", 18));
        personList.add(new Person("Bob", 14));
        personList.add(new Person("Tom", 15));
        personList.add(new Person("Pot", 16));
        Map<String, Person> map = Streams.of(personList).toMap(Person::getName, person -> person);
    }
}


