package com.algorithmforum.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 * 
 * https://www.youtube.com/watch?v=ddTC4Zovtbc&t=13s
 * 
 * 
 * Time Complexity: The above algorithm is simply DFS with an extra stack. So
 * time complexity is same as DFS which is O(V+E).
 * 
 * Applications: Topological Sorting is mainly used for scheduling jobs from the
 * given dependencies among jobs. In computer science, applications of this type
 * arise in instruction scheduling, ordering of formula cell evaluation when
 * recomputing formula values in spreadsheets, logic synthesis, determining the
 * order of compilation tasks to perform in makefiles, data serialization, and
 * resolving symbol dependencies in linkers
 * 
 * @author rajesh.dixit
 *
 */
public class TopologicalSortKahnAlgorithm {

	// This class represents a directed graph using adjacency list representation
	private static class Graph {

		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; // Adjacency List

		// Constructor
		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adj[i] = new LinkedList();
			}
		}

		// Function to add an edge into the graph
		void addEdge(int v, int w) {
			adj[v].add(w);
		}
	}

	/**
	 * t=Topological Sort Kahn's Algorithm.
	 * 
	 * @param graph
	 */
	private static void topologicalSortKahnAlgorithm(Graph graph) {

		// Initialize count of visited vertices
		int visitedCnt = 0;

		List<Integer> topSort = new LinkedList<>();

		int[] inDegrees = new int[graph.V];
		Queue<Integer> queue = new LinkedList<>();

		// Count in-degrees of each vertex.
		for (int i = 0; i < graph.V; i++) {
			LinkedList<Integer> adj = graph.adj[i];
			for (Integer vertex : adj) {
				inDegrees[vertex]++;
			}
		}

		// Pick the vertex has no dependency or in-degree = 0
		for (int i = 0; i < inDegrees.length; i++) {
			if (inDegrees[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			topSort.add(vertex);

			LinkedList<Integer> adj = graph.adj[vertex];
			for (int tVertex : adj) {

				// add the node to the queue if the in-degree will become zero.
				if (--inDegrees[tVertex] == 0) {
					queue.add(tVertex);
				}
			}
			visitedCnt++;
		}

		if (graph.V == visitedCnt) {
			System.out.println("Cycle in the graph");
		}

		System.out.println("Topological sort of the given graph " + topSort);
	}

	// Driver method
	public static void main(String args[]) {

		// Create a graph given in the above diagram
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);

		topologicalSortKahnAlgorithm(graph);
	}
}