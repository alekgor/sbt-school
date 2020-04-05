package com.sbt.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    // До Java 8
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(100, "green"));
        inventory.add(new Apple(110, "green"));
        inventory.add(new Apple(200, "green"));
        inventory.add(new Apple(151, "green"));
        inventory.add(new Apple(151, "red"));
        inventory.add(new Apple(161, "red"));
        inventory.add(new Apple(190, "red"));
        inventory.add(new Apple(120, "red"));

        // До JAVA 8
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        // Через анонимные классы не используя AppleGreenColorPredicate(),AppleHeavyWeightPredicate()
        heavyApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });

        greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });


        // JAVA 8 ======================================================================================================
        heavyApples = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);
        greenApples = filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));


        // Интерфейс с одним абстрактным методом называется функциональным.
        // ApplePredicate - функциональный интерфейс с абстракт.методом boolean test();
        // Основные:
        Apple apple = new Apple(200, "green");

        // проверка условия
        Predicate<Apple> predicate = a -> a.getWeight() > 150;
        predicate.test(apple); //true

        // получает объект
        Consumer<Apple> consumer = a -> System.out.println(a.getColor());
        consumer.accept(apple);

        // получает объект, возвращает результат
        Function<Apple, String> function = a -> "Color: " + a.getColor();
        function.apply(apple);

        // поставщик
        Supplier<String> supplier = () -> System.getProperties().toString(); // Выдает сво-ва системы


    }
}

