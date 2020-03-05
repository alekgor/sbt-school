package com.sbt.homework2;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Other {

    public static void main(String[] args) {
        LinkedHashMap<String,Integer> tableLinkedHashMap = new LinkedHashMap<>();
        tableLinkedHashMap.put("3",1);
        tableLinkedHashMap.put("2",1);
        tableLinkedHashMap.put("5",1);

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("3",1);
        treeMap.put("2",1);
        treeMap.put("5",1);
    }
}
