package com.sbt.homework10;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private List<T> list;

    public Streams(List<T> list) {
        this.list = list;
    }

    public static <T> Streams<T> of(Collection<? extends T> collection) {
        return new Streams<T>(new LinkedList<T>(collection));
    }

    public Streams<T> filter(Predicate<T> predicate) {
        List<T> resultList = new LinkedList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                resultList.add(el);
            }
        }
        list = resultList;
        return this;
    }

    public <R> Streams<R> transform(Function<T, R> func) {
        List<R> resultList = new LinkedList<>();
        for (T el : list) {
            resultList.add(func.apply(el));
        }
        return new Streams<>(resultList);
    }

    //terminal
    public <K, V> Map<K, V> toMap(Function<T, K> funcMapToKey, Function<T, V> funcMapToVal) {
        Map<K, V> map = new HashMap<>();
        for (T el : list) {
            map.put(funcMapToKey.apply(el), funcMapToVal.apply(el));
        }
        this.list = null; // "удалим" "поток", чтобы не использовался повторно
        return map;
    }

    //terminal
    public void forEachPrint() {
        for (T el : list) {
            System.out.println(el);
        }
        this.list = null;// "удалим" "поток", чтобы не использовался повторно
    }
}
