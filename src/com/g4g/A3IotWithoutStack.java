package com.g4g;

import java.util.Stack;

// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
public class A3IotWithoutStack {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    void runProgram() {
        TreeNode root = constructTree();
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //Go to left child till it is possible
        while(node != null || !stack.isEmpty()) {
            if(node == null) {
                node = stack.pop();
                System.out.print(node.data + "\t");
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }

    }

    private TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }
}
