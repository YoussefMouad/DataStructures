package com.github.YoussefMouad.DataStructures.Stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {
    @Test
    void TestPushItem() {
        IStack<Integer> stack = new LinkedListStack<>();
        assertEquals(0, stack.count());
        stack.push(10);
        assertEquals(10, stack.peek());

        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        assertEquals(5, stack.count());
        assertEquals(50, stack.peek());
    }

    @Test
    void TestPopItem() {
        IStack<Integer> stack = new LinkedListStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        assertEquals(50, stack.peek());
        assertEquals(50, stack.pop());
        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(0, stack.count());

        assertThrows(IllegalStateException.class, stack::peek);
        assertThrows(IllegalStateException.class, stack::pop);
    }
}