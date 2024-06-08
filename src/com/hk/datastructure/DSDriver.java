package com.hk.datastructure;

public class DSDriver {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(9);

        System.out.println("----------------------");
        binaryTree.printBinaryTreeLevelOrder();
        System.out.println("----------------------");
        binaryTree.printBinaryTreeInOrder();
        System.out.println("----------------------");
        binaryTree.printBinaryTreePostOrder();
        System.out.println("size : " +binaryTree.size());
        System.out.println(binaryTree.height());




    }
}
