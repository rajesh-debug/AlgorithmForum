package com.algorithmforum.graph;


public class GraphEdge {

    /** No of vertices. */
    public int V;

    /** No of edges. */
    public int E;

    /** Set of all edge in the graph. */
    public Edge edge[];

    static class Edge implements Comparable<Edge> {

        int src, dest, weight;

        // Comparator function used for sorting edges based on their weight 
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }

        @Override
        public String toString() {
            return String.format("[Souce: %d, Dest: %d, Weight: %d]", src, dest, weight);
        }
    }

    GraphEdge(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

}
