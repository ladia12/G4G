package com.g4g.util.graph;

public class VertexD implements Comparable<VertexD> {

    public int index;
    //shortest distance from source to this vertex
    public int dist;

    public VertexD(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(VertexD vertexD) {
        return this.dist - vertexD.dist;
    }
}
