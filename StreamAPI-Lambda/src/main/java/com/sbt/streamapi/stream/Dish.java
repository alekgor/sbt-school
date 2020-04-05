package com.sbt.streamapi.stream;

public class Dish {
    String name;
    Integer calories;
    Type type;

    public Dish(String name, Integer calories,Type t) {
        this.name = name;
        this.calories = calories;
        this.type = t;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
