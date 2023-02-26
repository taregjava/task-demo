package com.finehome.TestFineHome.task3;

public class Tree {
    // Root of Binary Tree
    Node root;

    Tree() {
        root = null;
    }

    void postorder(Node node) {
        if (node == null)
            return;

        // traverse the left child
        postorder(node.left);

        // traverse the right child
        postorder(node.right);

        // traverse the root node
        System.out.print(node.item + "->");
    }
}
