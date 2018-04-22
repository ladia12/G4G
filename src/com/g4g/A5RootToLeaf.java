package com.g4g;

import com.g4g.util.tree.Node;

// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
class A5RootToLeaf {


    void runProgram() {
        Node root = constructTree();
        boolean ans =  rootToLeaf(root, 11);
        System.out.println(ans);
    }

    private boolean rootToLeaf(Node root, int num) {

        if(root == null && num == 0) return true;

        if(root == null || num < root.data) return false;

        //noinspection SimplifiableIfStatement
        if(root.left == null && root.right == null && root.data == num) return true;

        return rootToLeaf(root.left, num - root.data) || rootToLeaf(root.right, num - root.data);
    }


    private Node constructTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        return root;
    }
}
