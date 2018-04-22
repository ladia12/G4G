package com.g4g;

import com.g4g.util.graph.Edge;
import com.g4g.util.graph.GraphW;
import com.g4g.util.graph.VertexD;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class A16Dijkstra {

    private GraphW graphW;
    private int[] dist;
    private int n;
    private boolean[] visited;
    // To store the previous nodes
    private int[] prev;

    private PriorityQueue<VertexD> queue;
    private List<Edge>[] adj;

    void runProgram() {
        graphW = GraphW.getWeightedGraph();
        n = graphW.getV();
        dist = new int[n];
        prev = new int[n];
        visited = new boolean[n];
        queue = new PriorityQueue<>();
        adj = graphW.getAdj();
        dijkstra(0);
        printResult();

    }

    void dijkstra(int s) {
        //set all distances to INT_MAX or infinity, except the source which is 0
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        // insert the source node in the priority queue
        queue.add(new VertexD(s, 0));
        //algorithm runs until queue is empty
        while (!queue.isEmpty()) {
            VertexD cur = queue.poll();
            //if popped vertex is visited then continue
            if(visited[cur.index]) continue;

            //mark current node as visited
            visited[cur.index] = true;

            // we find its unvisited neighbours
            for(Edge edge : adj[cur.index]) {
                //if visited then continue
                if(visited[edge.to]) continue;

                //calculate the new distance from source and update the distance if shorter
                int newD = dist[cur.index] + edge.weight;

                if(newD < dist[edge.to]) {
                    dist[edge.to] = newD;
                    queue.add(new VertexD(edge.to, newD));
                }
            }

        }
    }

    void printResult() {
        for(int i = 0; i < dist.length; i++){
            System.out.println("The shortest distance from 0 to " + i + " is " + dist[i]);
        }
    }
}
