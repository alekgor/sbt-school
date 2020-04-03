package com.sbt.serialization;

import java.util.Date;
import java.util.List;

public interface Service {

    // Набор разных методов более общего кеширования

    //    @Cache(cacheType = FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    @Cache(type = CacheType.FILE, zip = true)
    int sum(int a, int b) throws InterruptedException;

    @Cache(type = CacheType.IN_MEMORY, zip = true)
    String concat(String item1, String item2) throws InterruptedException;
}

