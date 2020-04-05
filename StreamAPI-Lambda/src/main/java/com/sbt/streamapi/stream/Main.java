package com.sbt.streamapi.stream;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Борщ", 600, Type.Meet));
        menu.add(new Dish("Яичница с беконом", 400, Type.Meet));
        menu.add(new Dish("Яблоко", 100, Type.Other));
        menu.add(new Dish("Бургер", 500, Type.Meet));
        menu.add(new Dish("Пивко", 300, Type.Other));
        menu.add(new Dish("Бутерброд", 200, Type.Other));
        menu.add(new Dish("Салат", 100, Type.Other));
        menu.add(new Dish("Бифштекс", 384, Type.Meet));
        menu.add(new Dish("Блины", 233, Type.Other));
        menu.add(new Dish("Котлеты курица", 222, Type.Meet));
        menu.add(new Dish("Рис", 344, Type.Other));
        menu.add(new Dish("Овсянка", 352, Type.Other));
        menu.add(new Dish("Окунь", 117, Type.Fish));
        menu.add(new Dish("Форель", 123, Type.Fish));
        menu.add(new Dish("Осетр", 164, Type.Fish));
        menu.add(new Dish("Сазан", 121, Type.Fish));


        // до Java 8
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
//        System.out.println(lowCaloricDishes);


        // JAVA 8
        lowCaloricDishesName = menu.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
//        System.out.println(lowCaloricDishes);

        // Creation
        // Collection.stream()
        Stream<Dish> dishStream = menu.stream();

        // Явное создание
        Stream<String> stringStream = Stream.of("1", "2", "3");

        // Из массива
        Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});

        // Из файла
//        Stream<String> stringStream1 = Files.lines(new File("file.txt").toPath());

        Consumer<Dish> printer = dish -> System.out.println(dish.name + ": " + dish.calories);

        List<Dish> others = menu.stream().filter(dish -> dish.getType().equals(Type.Other)).collect(Collectors.toCollection(ArrayList::new));

        Map<Boolean, List<Dish>> map = menu.parallelStream().collect(Collectors.partitioningBy(dish -> dish.getCalories() < 300));
        map.forEach((aBoolean, dishes) -> dishes.forEach(printer));

        Map<Type,List<Dish>> groupingMenuByType =  menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }
}
