package com.g4g.util.graph;

import java.util.LinkedList;
import java.util.List;

//Undirected Graph
public class GraphU {
    private int V;
    private List<Integer>[] adj;

    public GraphU(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    //contains cycle
    public static Graph getCyclicUndirectedGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }


}
