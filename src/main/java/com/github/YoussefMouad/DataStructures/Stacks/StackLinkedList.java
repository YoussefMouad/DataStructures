package com.github.YoussefMouad.DataStructures.Stacks;

import com.github.YoussefMouad.DataStructures.LinkedList;

public class StackLinkedList<T> implements IStack<T> {
    LinkedList<T> list;

    public StackLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        if (list.size() == 0)
            throw new IllegalStateException();

        var item = list.getFirst();
        list.deleteFirst();
        return item;
    }

    @Override
    public T peek() {
        if (list.size() == 0)
            throw new IllegalStateException();

        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int count() {
        return list.size();
    }
}
