package com.github.YoussefMouad.DataStructures.Queues;

import com.github.YoussefMouad.DataStructures.Stacks.IStack;
import com.github.YoussefMouad.DataStructures.Stacks.LinkedListStack;

public class QueueWithTwoStacks<T> implements IQueue<T> {
    private final IStack<T> enqueueStack;
    private final IStack<T> dequeueStack;

    public QueueWithTwoStacks() {
        this.enqueueStack = new LinkedListStack<>();
        this.dequeueStack = new LinkedListStack<>();
    }

    @Override
    public void enqueue(T item) {
        enqueueStack.push(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        fillDequeueStack();

        return dequeueStack.pop();
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        fillDequeueStack();

        return dequeueStack.peek();
    }

    private void fillDequeueStack() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
        }
    }

    @Override
    public boolean isEmpty() {
        return dequeueStack.isEmpty() && enqueueStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
