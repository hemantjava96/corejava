package com.hk.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T data) {
        insertData(this.root, data);
    }

    private void insertData(Node<T> node, T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
            return;
        }

        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return;
            } else {
                insertData(node.left, data);
            }
        } else if (data.compareTo(node.data) >= 0) {

            if (node.right == null) {
                node.right = new Node<>(data);
                return;
            } else {
                insertData(node.right, data);
            }
        }
    }

    public Integer size() {
       return countOfNodes(this.root);
    }

    private Integer countOfNodes(Node<T> root) {
        if (root==null)
            return 0;

        Integer leftNodeCount = countOfNodes(root.left);
        Integer rightNodeCount = countOfNodes(root.right);

        return leftNodeCount + rightNodeCount + 1;
    }

    /**
     * Prints the binary tree in levelorder traversal.
     */
    public void printBinaryTreeLevelOrder() {
        printLevelOrder();
    }

    /**
     * Helper method to print the binary tree in levelorder traversal.
     */
    private void printLevelOrder() {
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.offer(this.root);
        while (!nodes.isEmpty()) {
            int length = nodes.size();
            for (int i = 0; i < length; i++) {
                Node<T> node = nodes.poll();
                System.out.print(node.data);
                if (node.left != null)
                    nodes.offer(node.left);
                if (node.right != null)
                    nodes.offer(node.right);
            }
            System.out.println();
        }
    }

    /**
     * Prints the binary tree in postorder traversal.
     */
    public void printBinaryTreePostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    /**
     * Helper method to print the binary tree in postorder traversal.
     *
     * @param node The current node being processed.
     */
    private void printPostOrder(Node<T> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Prints the binary tree in inorder traversal.
     */
    public void printBinaryTreeInOrder() {
        printInOrder(root);
        System.out.println();
    }

    /**
     * Helper method to print the binary tree in inorder traversal.
     *
     * @param node The current node being processed.
     */
    private void printInOrder(Node<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public Integer height() {
        return getHeight(this.root);
    }

    private Integer getHeight(Node<T> root) {
        if(root==null)
            return 0;

        Integer leftHeight = getHeight(root.left);
        Integer rightHeihgt = getHeight(root.right);

        return Math.max(leftHeight,rightHeihgt) +1;
    }

    // Node
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }
}