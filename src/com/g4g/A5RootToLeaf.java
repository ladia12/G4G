package com.g4g;

import com.g4g.util.TreeNode;

// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
class A5RootToLeaf {


    void runProgram() {
        TreeNode root = constructTree();
        boolean ans =  rootToLeaf(root, 6);
        System.out.println(ans);
    }

    private boolean rootToLeaf(TreeNode root, int num) {

        if(root == null && num == 0) return true;

        if(root == null || num < root.data) return false;

        //noinspection SimplifiableIfStatement
        if(root.left == null && root.right == null && root.data == num) return true;

        return rootToLeaf(root.left, num - root.data) || rootToLeaf(root.right, num - root.data);
    }


    private TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        return root;
    }
}
