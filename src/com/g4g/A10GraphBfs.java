package com.g4g;


import com.g4g.util.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A10GraphBfs {
    private Graph graph;


    public void runProgram() {
        graph = Graph.createSampleGraph();
        BFS(2);

    }
    private void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        int n = graph.getNumNodes();
        List<Integer>[] adj = graph.getAdj();
        boolean visited[] = new boolean[n];
        queue.add(s);
        visited[s] = true;

        while(queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            for(Integer child : adj[s]) {
                if(!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }

        }


    }

}
