package com.sbt.serialization;

import java.io.File;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new File(".").getAbsolutePath());

        CacheProxy cacheProxy = new CacheProxy();
        Service s = cacheProxy.cache(new ServiceImpl(),"ServiceImplCache");
        s.sum(1,2);
        s.sum(1,3);
        s.sum(1,4);
        s.sum(1,2);

        s.concat("First","Second");
        s.concat("First","Seco");
        s.concat("First","Second");
        s.concat("First","Second");
        s.concat("1","2");
        s.concat("1","2");
        s.concat("1","2");
        s.concat("1","2");
        s.concat("1","2");
        s.concat("1","2");
        s.concat("1","3");


    }


}
