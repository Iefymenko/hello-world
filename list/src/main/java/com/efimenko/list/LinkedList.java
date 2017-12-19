package com.efimenko.list;

/**
 * Created by oiefymenko on 09/12/2015.
 */
public class LinkedList implements List{

    protected class Node {
        protected Node prev;
        protected Node next;
        protected Object value;

        public Node(Node prev, Node node, Object value) {
            this.prev = prev;
            this.next = node;
            this.value = value;
        }
    }

    protected Node first;
    protected Node last;
    protected int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(Object value) {
        Node current = new Node(last, null, value);
        if (size>0) {
            last.next = current;
        }
        else {
            first = current;
        }
        last = current;
        size++;
    }

    @Override
    public void add(int index, Object value) {

    }

    @Override
    public Object get(int index) {
        Node current = first;
        for (int i=1; i<=index; i++) {
            System.out.println("i="+i+" index="+index+" current.next="+current.next+" first.next="+first.next);
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void set(int index, Object value) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }
}
