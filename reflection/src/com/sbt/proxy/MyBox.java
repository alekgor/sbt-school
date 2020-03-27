package com.sbt.proxy;

public class MyBox implements IBox {
    Integer size = 0;

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public void setSize(Integer newSize) {
        this.size = newSize;
    }

    @Override
    public void print() {
        System.out.println("Size = " + size);
    }
}
