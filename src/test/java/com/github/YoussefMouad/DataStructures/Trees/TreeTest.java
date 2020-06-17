package com.github.YoussefMouad.DataStructures.Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree tree;

    @BeforeEach
    void init() {
        tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
    }

    @Test
    void testFindItemInTree() {
        assertTrue(tree.find(7));
        assertTrue(tree.find(10));
        assertFalse(tree.find(11));
    }

    @Test
    void testTraversPreOrder() {
        tree.traversPreOrder();
        tree.traversInOrder();
        tree.traversPostOrder();
    }

    @Test
    void testHeight() {
        assertEquals(-1, new Tree().height());
        assertEquals(2, tree.height());
        tree.insert(11);
        assertEquals(3, tree.height());
    }

    @Test
    void testMinValue() {
        assertEquals(1, tree.min());
        tree.insert(0);
        assertEquals(0, tree.min());
        assertThrows(IllegalStateException.class, () -> new Tree().min());
    }

    @Test
    void testEquals() {
        assertTrue(tree.equals(tree));
        assertFalse(tree.equals(null));
        assertFalse(tree.equals(new Tree()));
    }

    @Test
    void testValidBinarySearchTree() {
        assertTrue(tree.isBinarySearchTree());
    }
}