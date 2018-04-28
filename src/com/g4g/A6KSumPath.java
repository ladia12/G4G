package com.g4g;

import com.g4g.util.tree.Node;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class A6KSumPath {
    void runProgram() {
        Node root = constructTree();
        kSumPath(root, 5, new ArrayList<Integer>());
    }

    private void kSumPath(Node root, int k, List<Integer> path) {
        if(root == null) return;

        path.add(root.data);

        //check left subtree
        kSumPath(root.left, k, path);

        //check right subtree
        kSumPath(root.right, k, path);


        //check if there is any ksum path upto current node
        int sum = 0;
        for(int i = path.size()-1; i>=0; i--) {
            sum+= path.get(i);
            if(sum == k) {
                printSum(path, i);
                break;
            }
        }

        path.remove(path.size() -1);
    }

    private void printSum(List<Integer> path, int index) {
        for(int i = index; i<path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
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
