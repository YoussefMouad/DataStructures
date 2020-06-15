package com.github.YoussefMouad.DataStructures.Queues;

import com.github.YoussefMouad.DataStructures.LinkedList;

public class LinkedListQueue<T> implements IQueue<T> {
    private LinkedList<T> items;

    public LinkedListQueue() {
        items = new LinkedList<>();
    }

    @Override
    public void enqueue(T item) {
        items.addLast(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item  = items.getFirst();
        items.deleteFirst();
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
