package com.github.YoussefMouad.DataStructures.Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void testBalance() {
        var tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertTrue(tree.isBalanced());

        tree = new AVLTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        assertTrue(tree.isBalanced());
    }
}