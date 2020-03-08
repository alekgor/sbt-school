package com.sbt.homework2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

//Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
public class Task5 {

    public static class MyLinkedListWithReverseIterator extends LinkedList<Integer> {
        @Override
        public Iterator<Integer> iterator() {
            return new Itr(super.size());
        }

        private class Itr implements Iterator<Integer> {
            int cursor;

            public Itr(int cursor) {
                this.cursor = cursor;
            }

            @Override
            public boolean hasNext() {
                return cursor - 1 >= 0;
            }

            @Override
            public Integer next() {
                int i = cursor;
                if (i < 0)
                    throw new NoSuchElementException();
                cursor -= 1;
                return MyLinkedListWithReverseIterator.this.get(cursor);
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedListWithReverseIterator list = new MyLinkedListWithReverseIterator();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.forEach(System.out::println);
    }
}
