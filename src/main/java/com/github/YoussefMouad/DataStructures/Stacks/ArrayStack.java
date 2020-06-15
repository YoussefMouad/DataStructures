package com.github.YoussefMouad.DataStructures.Stacks;

public class ArrayStack<T> implements IStack<T> {
    private T[] items;
    private int index;

    public ArrayStack() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        items = (T[]) new Object[size];
    }

    @Override
    public void push(T item) {
        if (index == items.length)
            throw new StackOverflowError();
        items[index++] = item;
    }

    @Override
    public T pop() {
        if (index == 0)
            throw new IllegalStateException();
        return items[--index];
    }

    @Override
    public T peek() {
        if (index == 0)
            throw new IllegalStateException();
        return items[index - 1];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int count() {
        return index;
    }
}
