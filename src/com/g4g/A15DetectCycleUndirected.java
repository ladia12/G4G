package com.g4g;

import com.g4g.util.graph.Graph;
import com.g4g.util.graph.GraphU;

import java.util.List;

public class A15DetectCycleUndirected {
    private Graph graph;
    private List<Integer>[] adj;
    private boolean visited[];

    void runProgram() {
        graph = GraphU.getCyclicUndirectedGraph();
        adj = graph.getAdj();
        int n = graph.getNumNodes();
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(isCyclic(i, -1)) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }

    /**
     *
     * @param v current vertex
     * @param u parent vertex
     * @return
     */
    boolean isCyclic(int v, int u) {
        visited[v] = true;
        for(Integer i: adj[v]) {
            // If an adjacent is not visited, then recurse
            if(!visited[i]) {
                if(isCyclic(i, v)) return true;
            }
            //elseif, if it is visited and not parent of v then there is a cycle
            else if(i != u) return true;
        }
        return false;
    }
}
