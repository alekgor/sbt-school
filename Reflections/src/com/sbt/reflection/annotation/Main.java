package com.sbt.reflection.annotation;


import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)              //К чему применима аннотация
//@Inherited                            //Наследники помеченного class тоже будут помечены
@Retention(RetentionPolicy.RUNTIME)     //Жизненный цикл аннотации
@interface Show{
    boolean value() default true;       //Атрибутами аннотации могут быть только примитивы
}

class Person{
    int age = 18;

    @Show
    String name = "Person";
}

public class Main {
    // Выводит поля класса, которые с аннотацией @Show
    static void print(Object o, Class c) throws IllegalAccessException {
        Field[] fields = c.getDeclaredFields();                     //Получаем поля класса
        for (Field f: fields) {
            Annotation[] annotations = f.getDeclaredAnnotations();  // Для каждого поля получаем список аннотаций
            for (Annotation an: annotations) {
                if (an.annotationType().equals(Show.class)) {       // Проверяем каждую аннотацию, если есть @Show то печатаем поле
                    System.out.println(f.get(o));
                }
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        Person per = new Person();
        print(per,per.getClass());
    }
}
