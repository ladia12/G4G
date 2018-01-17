package com.g4g;

public class A4DiameterBT {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class Height {
        int h;

        public Height() {
        }
    }


    public void runProgram() {
        TreeNode root = constructTree();
        int dia = cDiameter(root, new Height());
        System.out.println(dia);
    }

    private int cDiameter(TreeNode root, Height height) {
        if(root == null) return 0;
        Height lh  = new Height();
        int ld = cDiameter(root.left, lh);
        Height rh = new Height();
        int rd = cDiameter(root.right, rh);
        height.h = 1 + Math.max(lh.h, rh.h);
        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));

    }

    private int diameter(TreeNode root) {
        if(root == null) return 0;
        int dia = 1 + height(root.left) + height(root.right);
        return Math.max(dia, Math.max(diameter(root.left) , diameter(root.right)));
    }

    private int height(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left) , height(node.right));
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
