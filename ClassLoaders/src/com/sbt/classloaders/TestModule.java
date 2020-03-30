package com.sbt.classloaders;

public class TestModule {
    Integer i=0;
    public String toString()
    {
        i++;
        return "com.sbt.classloaders.TestModule, version 2!" + i;
    }
}
