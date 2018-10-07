package com.algorithmforum.graph;

import java.util.Arrays;

/**
 * An application of disjoint-set data structures.
 * 
 * @author rajesh.dixit
 * @since Oct 3, 2018 11:18:35 AM
 */
public class KruskalsDisjointSet {


    public static void kruskalMST(GraphEdge graph) {
        // To store the edge of MST.
        Edge result[] = new Edge[graph.V];

        // Sort the edge by weight.
        Arrays.sort(graph.edge);

        // Make set of all vertex.
        DisjointSet disjointSet = new DisjointSet();

        for (int v = 0; v < graph.V; v++) {
            disjointSet.makeSet(v);
        }
        
        int i = 0;
        for (Edge edge : graph.edge) {
            int v1 = edge.src;
            int v2 = edge.dest;
            if (disjointSet.findSet(v1) != disjointSet.findSet(v2)) {
                disjointSet.union(v1, v2);
                result[i++] = edge;
            }
        }

        System.out.println("Minimum spanning tree is: ");
        System.out.println(Arrays.deepToString(result));
    }


    // Driver program
    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph 
        int E = 5; // Number of edges in graph 
        GraphEdge graph = new GraphEdge(V, E);

        // add edge 0-1 
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3 
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3 
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3 
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
        
        kruskalMST(graph);
    }
}