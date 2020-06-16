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

    public int height(){
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        if (node.left == null && node.right == null)
            return 0;

        return 1 + Math.max(
                height(node.left),
                height(node.right)
        );
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
