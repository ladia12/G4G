package com.g4g;

import com.g4g.util.graph.Graph;

import java.util.List;

public class A11GraphDfs{

    private Graph graph;
    private List<Integer>[] adj;
    private boolean visited[];

    void runProgram() {
        graph = Graph.createSampleGraph();
        int n = graph.getNumNodes();
        adj = graph.getAdj();
        visited = new boolean[n];
        DFS(0);
    }

    void DFS(int s) {
        System.out.print(s + " ");
        visited[s] = true;
        for(Integer cur : adj[s]) {
            if(!visited[cur]) {
                DFS(cur);
            }
        }
    }
}
