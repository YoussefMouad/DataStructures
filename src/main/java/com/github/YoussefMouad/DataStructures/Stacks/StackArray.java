package com.github.YoussefMouad.DataStructures.Stacks;

public class StackArray<T> implements IStack<T> {
    private T[] items;
    private int index;

    public StackArray() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public StackArray(int size) {
        items = (T[]) new Object[size];
    }

    public void push(T item) {
        if (index == items.length)
            throw new StackOverflowError();
        items[index++] = item;
    }

    public T pop() {
        if (index == 0)
            throw new IllegalStateException();
        return items[--index];
    }

    public T peek() {
        if (index == 0)
            throw new IllegalStateException();
        return items[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int count() {
        return index;
    }
}
