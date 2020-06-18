package com.github.YoussefMouad.DataStructures.Trees;

// Self balanced Tree
public class AVLTree {
    private Node root;

    public void insert(int item) {
        root = insert(root, item);
    }

    private Node insert(Node node, int item) {
        if (node == null)
            return new Node(item);

        if (item < node.value)
            node.left = insert(node.left, item);
        else node.right = insert(node.right, item);

        setHeight(node);

        return balance(node);
    }

    private Node balance(Node node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.left) < 0)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.right) > 0)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node leftRotate(Node node) {
        var newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rightRotate(Node node) {
        var newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(
                height(node.left),
                height(node.right)) + 1;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public boolean isBalanced() {
        return !(isLeftHeavy(root) || isRightHeavy(root));
    }

    private static class Node {
        private final int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }
}
