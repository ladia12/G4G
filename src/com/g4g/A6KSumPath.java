package com.g4g;

import com.g4g.util.tree.Node;

// https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class A6KSumPath {
    void runProgram() {
        Node root = constructTree();
        boolean ans =  kSumPath(root, 5);
        System.out.println(ans);
    }

    private boolean kSumPath(Node root, int k) {
        return false;
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
