package com.algorithmforum.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 10/11/2018
 *
 * Find minimum spanning tree using Prim's algorithm
 *
 * Space complexity - O(E + V) Time complexity - O(ElogV)
 *
 * References https://en.wikipedia.org/wiki/Prim%27s_algorithm
 * 
 * CLRS book
 */
public class PrimsMST {

	/**
	 * Main method of Prim's algorithm.
	 */
	public List<Edge> primMST(GraphEdge graph) {

		// binary heap + map data structure
		BinaryMinHeap<Integer> minHeap = new BinaryMinHeap<>();

		// map of vertex to edge which gave minimum weight to this vertex.
		Map<Integer, Edge> vertexToEdge = new HashMap<>();

		// stores final result
		List<Edge> result = new ArrayList<>();

		// insert all vertices with infinite value initially.
		for (int v = 0; v < graph.V; v++) {
			minHeap.add(Integer.MAX_VALUE, v);
		}

		// start from any random vertex
		int startVertex = 0;

		// for the start vertex decrease the value in heap + map to 0
		minHeap.decrease(startVertex, 0);

		while (!minHeap.empty()) {
			int current = minHeap.extractMin();

			Edge spanningTreeEdge = vertexToEdge.get(current);
			if (spanningTreeEdge != null) {
				result.add(spanningTreeEdge);
			}
			// iterate through all the adjacent vertices
			for (Edge edge : graph.adjList[current]) {
				int weight = edge.weight;
				int adjacent = edge.dest;

				if (minHeap.containsData(adjacent) && weight < minHeap.getWeight(adjacent)) {

					vertexToEdge.put(adjacent, edge);

					// decrease the value of adjacent vertex to this edge weight.
					minHeap.decrease(adjacent, weight);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		GraphEdge graph = new GraphEdge(6, 9);

		graph.edge[1] = new Edge(graph, 0, 1, 3);
		graph.edge[1] = new Edge(graph, 1, 2, 1);
		graph.edge[1] = new Edge(graph, 2, 0, 1);
		graph.edge[1] = new Edge(graph, 0, 3, 1);
		graph.edge[1] = new Edge(graph, 1, 3, 3);
		graph.edge[1] = new Edge(graph, 3, 4, 6);
		graph.edge[1] = new Edge(graph, 4, 5, 2);
		graph.edge[1] = new Edge(graph, 2, 4, 5);
		graph.edge[1] = new Edge(graph, 2, 5, 4);

		PrimsMST prims = new PrimsMST();
		Collection<Edge> edges = prims.primMST(graph);
		for (Edge edge : edges) {
			System.out.println(edge);
		}
	}
}