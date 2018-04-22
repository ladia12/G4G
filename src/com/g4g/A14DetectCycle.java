package com.g4g;

import com.g4g.util.graph.Graph;

import java.util.List;

public class A14DetectCycle {

    private Graph graph;
    private List<Integer>[] adj;
    private boolean visited[];
    private boolean recStack[];
    void runProgram() {

        graph = Graph.getCyclicDGraph();
        int n = graph.getNumNodes();
        adj = graph.getAdj();
        visited = new boolean[n];
        recStack = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(isCyclic(i)){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    boolean isCyclic(int s) {
        if(!visited[s]) {

            visited[s] = true;
            recStack[s] = true;
            for(Integer cur : adj[s]) {
                if(!visited[cur] && isCyclic(cur)) {
                    return true;
                } else if(recStack[cur]) {
                    return true;
                }
            }
        }

        recStack[s] = false;
        return false;
    }

}
