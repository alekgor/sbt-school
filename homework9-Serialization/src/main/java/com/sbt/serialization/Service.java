package com.sbt.serialization;

public interface Service {

    // Набор разных методов более общего кеширования
    @Cache(type = CacheType.FILE, zip = true)
    int sum(int a, int b) throws InterruptedException;

    @Cache(type = CacheType.FILE, zip = true)
    String concat(String item1, String item2) throws InterruptedException;
}

