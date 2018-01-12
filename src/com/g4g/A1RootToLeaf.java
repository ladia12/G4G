package com.g4g;

//https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
class A1RootToLeaf {
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
        int minHeight = findMinHeight(root);
        System.out.println(minHeight);
    }

    private TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }

    private int findMinHeight(TreeNode node) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 1;

        if(node.left == null) {
            return 1 + findMinHeight(node.right);
        }

        if(node.right == null) {
            return  1 + findMinHeight(node.left);
        }

        return 1 + Math.min(findMinHeight(node.left), findMinHeight(node.right));
    }




}
