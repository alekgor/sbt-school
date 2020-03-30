package com.sbt.classloaders;

public class DynamicModule extends TrueStaticModule {
    public String toString()
    {
        return "DynamicModule, version 1! "+(counter++);
    }
}
