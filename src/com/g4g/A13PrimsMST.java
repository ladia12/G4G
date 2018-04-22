package com.g4g;

import com.g4g.util.graph.Edge;
import com.g4g.util.graph.GraphW;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A13PrimsMST {

    void runProgram() {
        GraphW graphW = GraphW.getWeightedGraph();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<Edge> mst = new ArrayList<>();
        int V = graphW.getV();
        List<Edge>[] adj = graphW.getAdj();
        boolean visited[] = new boolean[V];
        int cost = 0;

        //marked 0 as visited
        visited[0] = true;

        // Add all edges connected to 0 to PQueue
        pq.addAll(adj[0]);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            //if we have visited the opposite vertex of the edge, go to the next vertex
            if(visited[e.to]) continue;

            //mark the opposite vertex as visited
            visited[e.to] = true;

            //add edge to mst and increase the cost
            mst.add(e);
            cost += e.weight;

            //add every edge connected to opposite vertex add it to PQueue
            for(Edge edge: adj[e.to]) {
                if(!visited[edge.to]) pq.add(edge);
            }

        }

        System.out.println("Total cost: " + cost);

        // print all the edges of the mst
        for(Edge edge: mst) {
            System.out.println(edge.from + " - " + edge.to);
        }

    }
}
