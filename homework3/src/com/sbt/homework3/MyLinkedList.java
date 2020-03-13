package com.sbt.homework3;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }



    public MyLinkedList() {
    }

    public MyLinkedList(Node<E> first) {
        this.first = first;
    }

    public MyLinkedList(Node<E> first, Node<E> last) {
        this.first = first;
        this.last = last;
    }

    public void add(E element) {
        final Node<E> l = this.last;
        final Node<E> newNode = new Node<>(l, element, null);
        this.last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
    }

    public void add(int index, E element) {
        if (index == 0) {
            this.first = new Node<>(null, element, this.first);
        } else {
            Node<E> x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            Node<E> prev = x.prev;
            Node<E> newNode = new Node<>(prev, element, x);
            prev.next = newNode;
            x.prev = newNode;
        }
    }

    public E get(int index){
        Node<E> x = this.first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.value;
    }

    public void print() {
        Node<E> it = this.first;
        System.out.print("[ ");
        while (it != null) {
            System.out.print(it.value + " ");
            it = it.next;
        }
        System.out.println("]");

    }

}
