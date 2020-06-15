package com.github.YoussefMouad.DataStructures.Queues;

public interface IQueue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
