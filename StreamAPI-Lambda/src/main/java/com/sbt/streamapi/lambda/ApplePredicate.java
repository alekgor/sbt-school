package com.sbt.streamapi.lambda;

// До Java 8
@FunctionalInterface //Java8
public interface ApplePredicate {
    boolean test(Apple apple);
}
