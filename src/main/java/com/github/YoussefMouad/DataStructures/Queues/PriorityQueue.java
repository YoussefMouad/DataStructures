package com.github.YoussefMouad.DataStructures.Queues;

public class PriorityQueue<T extends Comparable<? super T>> implements IQueue<T> {
    private final Object[] items;
    private int count;

    public PriorityQueue() {
        this(10);
    }

    public PriorityQueue(int size) {
        this.items = new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    @SuppressWarnings("unchecked")
    private int shiftItemsToInsert(T item) {
        int i;
        for (i = count - 1; i >= 0; --i) {
            if (item.compareTo((T)items[i]) < 0)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        T item = (T)items[count - 1];
        items[count--] = null;
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return (T)items[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == items.length;
    }
}
