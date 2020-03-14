package com.sbt.homework3;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    MyLinkedList<Integer> intList = new MyLinkedList<>();
	    intList.add(1);
	    intList.add(2);
	    intList.add(3);
	    intList.add(4);
	    intList.add(5);
	    intList.add(6);
	    intList.print();

	    MyLinkedList<String> stringList = new MyLinkedList<>();
		stringList.add("1a");
		stringList.add("2b");
		stringList.add("3c");
		stringList.add("4d");
		stringList.add("5e");

		stringList.print();
		stringList.remove(0);
		stringList.print();

		LinkedList<Integer> ints = new LinkedList<>();
		ints.add(213312);
		ints.add(213121312);
		ints.add(254);
		ints.add(13233);

		intList.addAll(ints);
		intList.print();

	}
}
