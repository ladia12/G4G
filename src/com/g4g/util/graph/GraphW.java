package com.g4g.util.graph;

import java.util.LinkedList;
import java.util.List;

/*
    Weighted graph
 */
public class GraphW {
    private int V;
    private int E;
    private List<Edge>[] adj;

    public GraphW(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    /**
     *
     * @param u source vertex
     * @param v destination vertex
     * @param w weight of the edge
     */
    private void addEdge(int u, int v, int w) {
        adj[u].add(new Edge(u, v, w));
        adj[v].add(new Edge(v, u, w));
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<Edge>[] getAdj() {
        return adj;
    }

    //Used for Dijkstra's algorithm as well
    public static GraphW getWeightedGraph() {
        GraphW g = new GraphW(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
        return g;
    }
}
