package com.g4g.util.graph;

import java.util.LinkedList;
import java.util.List;


//Directed graph
public class Graph {
    private int V;
    private List<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int getNumNodes(){
        return V;
    }

    public List<Integer>[] getAdj() {
        return adj;
    }

    public static Graph createSampleGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }

    public static Graph getGraphTopoSort() {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        return g;
    }

    public static Graph getCyclicDGraph() {
        //contains cycle
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
