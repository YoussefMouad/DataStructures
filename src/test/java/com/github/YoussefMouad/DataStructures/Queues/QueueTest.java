package com.github.YoussefMouad.DataStructures.Queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    void testEnqueueDequeue(IQueue<Integer> queue) {
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
        assertThrows(IllegalStateException.class, queue::peek);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        if (queue.getClass() == ArrayQueue.class) {
            assertTrue(queue.isFull());
            assertThrows(IllegalStateException.class, () -> queue.enqueue(40));
        }

        assertEquals(10, queue.peek());
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());

        queue.enqueue(40);
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    void testArrayQueue() {
        testEnqueueDequeue(new ArrayQueue<>(3));
    }

    @Test
    void testLinkedListQueue() {
        testEnqueueDequeue(new LinkedListQueue<>());
    }

    @Test
    void testQueueWithTwoStacks() {
        testEnqueueDequeue(new QueueWithTwoStacks<>());
    }

    @Test
    void testPriorityQueue() {
        IQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(5);

        assertEquals(7, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
        queue.enqueue(2);
        assertEquals(2, queue.peek());
    }
}