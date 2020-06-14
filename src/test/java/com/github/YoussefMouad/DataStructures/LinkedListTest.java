package com.github.YoussefMouad.DataStructures;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testAddingDeletingElements() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, list::deleteFirst);
        assertThrows(NoSuchElementException.class, list::deleteLast);

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        list.deleteFirst();
        list.deleteLast();

        assertEquals(20, list.getLast());
        assertEquals(10, list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    void testIndexOfAndContains() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertEquals(2, list.indexOf(30));
        assertEquals(0, list.indexOf(10));
        assertEquals(-1, list.indexOf(50));

        assertTrue(list.contains(10));
        assertFalse(list.contains(50));
    }

    @Test
    void testToArray() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        var array = new Integer[0];
        array = list.toArray(array);

        assertEquals(3, array.length);
        assertEquals(20, array[1]);
    }

    @Test
    void testReverse(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.reverse();

        assertEquals(10, list.getLast());
        assertEquals(40, list.getFirst());
    }
}