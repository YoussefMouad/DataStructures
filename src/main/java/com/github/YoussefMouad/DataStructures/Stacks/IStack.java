package com.github.YoussefMouad.DataStructures.Stacks;

public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int count();
}
