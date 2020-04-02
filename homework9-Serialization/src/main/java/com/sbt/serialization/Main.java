package com.sbt.serialization;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CacheProxy cacheProxy = new CacheProxy();
        Service s = cacheProxy.cache(new ServiceImpl());
        s.sum(1,2);
        s.sum(1,3);
        s.sum(1,4);
        s.sum(1,2);

        s.concat("First","Second");
        s.concat("First","Seco");
        s.concat("First","Second");
        s.concat("First","Second");


    }


}
