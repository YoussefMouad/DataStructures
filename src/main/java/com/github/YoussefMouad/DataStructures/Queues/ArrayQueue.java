package com.github.YoussefMouad.DataStructures.Queues;

public class ArrayQueue<T> implements IQueue<T> {
    private final T[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        this.items = (T[])new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException();

        items[rear] = item;
        // Circular array
        rear = (rear + 1) % items.length;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        T item = items[front];
        items[front] = null;

        front = (front + 1) % items.length;
        count--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
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
