package com.algorithmforum.graph;

import java.util.ArrayList;

class Edge implements Comparable<Edge> {

	int src, dest, weight;

	public Edge(GraphEdge graph, int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;

		graph.adjList[src].add(this);

	}

	// Comparator function used for sorting edges based on their weight
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}

	@Override
	public String toString() {
		return String.format("[Souce: %d, Dest: %d, Weight: %d]", src, dest, weight);
	}
}

public class GraphEdge {

	/** No of vertices. */
	public int V;

	/** No of edges. */
	public int E;

	/** Set of all edge in the graph. */
	public Edge edge[];

	// adjacency list
	public ArrayList<Edge>[] adjList;

	// utility method to initialise adjacency list
	@SuppressWarnings("unchecked")
	private void initAdjList() {
		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	GraphEdge(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];

		initAdjList();
		/*
		 * for (int i = 0; i < e; ++i) { edge[i] = new Edge(); }
		 */
	}

}
