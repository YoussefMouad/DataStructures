package com.github.YoussefMouad.DataStructures;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirst(T item) {
        var node = new Node<>(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(T item) {
        var node = new Node<>(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        // A single item in the list
        if (first == last)
            first = last = null;
        else {
            var node = first.next;
            first.next = null;
            first = node;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        // A single item in the list
        if (first == last)
            first = last = null;
        else {
            last = getPrevious(last);
            if (last != null)
                last.next = null;
        }
        size--;
    }

    private Node<T> getPrevious(Node<T> node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int indexOf(T item) {
        int index = 0;
        var node = first;

        while (node != null) {
            if (node.value == item) return index;
            index++;
            node = node.next;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] array) {
        array = (E[]) Array.newInstance(array.getClass().getComponentType(), size);
        int index = 0;
        var node = first;

        while (node != null) {
            array[index++] = (E) (node.value);
            node = node.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
