package com.algorithmforum.graph;

import java.util.ArrayList;

/**
 * An application of disjoint-set data structures
 * 
 * The procedure CONNECTED-COMPONENTS that follows uses the disjoint-set operations to compute the connected
 * components of a graph. Once CONNECTED COMPONENTS has preprocessed the graph, the procedure SAME-COMPONENT
 * answers queries about whether two vertices are in the same connected component.
 * 
 * @author rajesh.dixit
 * @since Sep 11, 2018 12:42:46 PM
 */
public class ConnectedComponentDisjointSet {

    /**
     * We are using the Disjoint approach for connected components.
     * 
     * @param g
     * @param v1
     * @param v2
     * @return boolean value
     */
    private static boolean findConnectedComponents(Graph g, long v1, long v2) {

        DisjointSet disjointSet = new DisjointSet();

        // make set, parent of set is itself and initially rank will be zero.
        for (int v = 0; v < g.v; v++) {
            disjointSet.makeSet(v);
        }

        ArrayList<Integer>[] adjList = g.adjList;

        // traverse all edge to make disjoint set.
        for (int s = 0; s < adjList.length; s++) {

            for (int d : adjList[s]) {

                // if parent is not same vertex of the edge, union them.
                if (disjointSet.findSet(s) != disjointSet.findSet(d)) {
                    disjointSet.union(s, d);
                }

                // check that both vertex is connected or not.
                if (isSameComponets(v1, v2, disjointSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * If parent representative of both vertex is same than both vertex are connected components.
     * 
     * @param v1
     * @param v2
     * @param disjointSet
     * @return true
     */
    private static boolean isSameComponets(long v1, long v2, DisjointSet disjointSet) {
        return disjointSet.findSet(v1) == disjointSet.findSet(v2);
    }

    // Driver program
    public static void main(String[] args) {
        // Create a sample graph
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        g.addEdge(4, 5);

        // arbitrary source
        int s = 2;
        // arbitrary destination
        int d = 3;

        System.out.println(String.format("%s and %s are connected %b", s, d, findConnectedComponents(g, s, d)));
    }
}
