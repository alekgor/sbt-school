package com.sbt.homework10;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    public List<T> list;

    public Streams(List<T> list) {
        this.list = list;
    }

    public static <T> Streams<T> of(Collection<? extends T> collection) {
        return new Streams<>(new LinkedList<T>(collection));
    }

    public Streams<T> filter(Predicate<T> predicate) {
        List<T> reslist = new LinkedList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                reslist.add(el);
            }
        }
        list = reslist;
        return this;
    }

    public <R> Streams<R> transform(Function<T, R> func) {
        List<R> reslist = new LinkedList<>();
        for (T el : list) {
            reslist.add(func.apply(el));
        }
        return new Streams<>(reslist);
    }

}
