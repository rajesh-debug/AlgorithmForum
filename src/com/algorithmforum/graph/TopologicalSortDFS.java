package com.algorithmforum.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/topological-sorting/
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
public class TopologicalSortDFS {

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
	 * Recursive method to insert the element in stack if all children are visited.
	 * 
	 * @param element
	 * @param visited
	 * @param stack
	 */
	private static void topologicalSort(Graph graph, int element, boolean[] visited, Stack<Integer> stack) {
		visited[element] = true;

		LinkedList<Integer> adj = graph.adj[element];

		for (int i = 0; i < adj.size(); i++) {
			int childVertex = adj.get(i);
			if (!visited[childVertex]) {
				topologicalSort(graph, childVertex, visited, stack);
			}
		}

		stack.push(element);
	}

	/**
	 * Utility to call recursive sort method.
	 * 
	 * @param graph
	 */
	private static void topologicalSortUtil(Graph graph) {

		boolean[] visited = new boolean[graph.adj.length];
		Stack<Integer> stack = new Stack<>();

		for (int vertex = 0; vertex < graph.V; vertex++) {
			if (!visited[vertex]) {
				topologicalSort(graph, vertex, visited, stack);
			}
		}

		System.out.println("Following is a Topological sort of the given graph");

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
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

		topologicalSortUtil(graph);
	}
}