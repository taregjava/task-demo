package com.finehome.TestFineHome.task3;

public class PostOrder {

    public static void main(String[] args) {
        Tree tree = new Tree();

        // create nodes of the tree
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);

        // child nodes of left child
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        // postorder tree traversal
        System.out.println("Postorder traversal");
        tree.postorder(tree.root);
    }

}
