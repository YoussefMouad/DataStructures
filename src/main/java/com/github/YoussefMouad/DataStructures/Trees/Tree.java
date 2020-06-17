package com.github.YoussefMouad.DataStructures.Trees;

public class Tree {
    private Node root;

    public void insert(int item) {
        if (root == null) {
            root = new Node(item);
            return;
        }

        var node = root;
        var newNode = new Node(item);
        while (true) {
            if (item < node.value) {
                if (node.left == null) {
                    node.left = newNode;
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    break;
                }
                node = node.right;
            }
        }
    }

    public boolean find(int item) {
        var node = root;
        while (node != null) {
            if (item < node.value)
                node = node.left;
            else if (item > node.value)
                node = node.right;
            else return true;
        }
        return false;
    }

    public void traversPreOrder() {
        traversPreOrder(root);
    }

    // root => left => right
    private void traversPreOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        traversPreOrder(node.left);
        traversPreOrder(node.right);
    }

    public void traversInOrder() {
        traversInOrder(root);
    }

    // left => root => right
    private void traversInOrder(Node node) {
        if (node == null) return;
        traversInOrder(node.left);
        System.out.println(node.value);
        traversInOrder(node.right);
    }

    public void traversPostOrder() {
        traversPostOrder(root);
    }

    // left => right => root
    private void traversPostOrder(Node node) {
        if (node == null) return;
        traversPostOrder(node.left);
        traversPostOrder(node.right);
        System.out.println(node.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        if (isLeaf(node))
            return 0;

        return 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }

    // O(log n) If it's a binary search tree only check for left node
    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    // O(n) => if is a binary tree
    private int min(Node node) {
        if (isLeaf(node))
            return node.value;

        var left = node.left == null ? node.value : min(node.left);
        var right = node.right == null ? node.value : min(node.right);

        return Math.min(Math.min(left, right), node.value);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public boolean equals(Tree tree) {
        if (tree == null)
            return false;
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.left, second.left)
                    && equals(first.right, second.right);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidNode(Node node, int min, int max) {
        if (node == null) return true;

        if (node.value >= max || node.value <= min)
            return false;

        return isValidNode(node.left, min, node.value)
                && isValidNode(node.right, node.value, max);
    }

    private static class Node {
        private final int value;
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
