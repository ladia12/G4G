package com.g4g;

import com.g4g.util.graph.Graph;

import java.util.List;
import java.util.Stack;

public class A12GraphTopoSort {

    private Graph graph;
    private boolean visited[];
    private List<Integer>[] adj;
    private Stack<Integer> stack;

    void runProgram() {
        graph = Graph.getGraphTopoSort();
        int n = graph.getNumNodes();
        visited = new boolean[n];
        adj = graph.getAdj();
        stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) topoSort(i);
        }
        printTopo();
    }

    void topoSort(int s) {
        visited[s] = true;
        for(Integer cur: adj[s]) {
            if(!visited[cur]) topoSort(cur);
        }
        stack.push(s);
    }

    void printTopo() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


}
