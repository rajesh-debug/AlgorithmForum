package com.algorithmforum.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * https://www.geeksforgeeks.org/maximum-edges-can-added-dag-remains-dag/
 * https://www.geeksforgeeks.org/assign-directions-to-edges-so-that-the-directed-graph-remains-acyclic/
 * 
 * Time Complexity: The above algorithm is simply DFS with an extra stack. So
 * time complexity is same as DFS which is O(V+E).
 * 
 * 1) Consider the subgraph with directed edges only and find topological
 * sorting of the subgraph. In the above example, topological sorting is {0, 5,
 * 1, 2, 3, 4}. Below diagram shows topological sorting for the above example
 * graph. second
 * 
 * 2) Use above topological sorting to assign directions to undirected edges.
 * For every undirected edge (u, v), assign it direction from u to v if u comes
 * before v in topological sorting, else assign it direction from v to u. Below
 * diagram shows assigned directions in the example graph.
 * 
 * @author rajesh.dixit
 */
public class AssignEdgesDAGRemainsAcyclic {

	// This class represents a directed graph using adjacency list representation
	private static class Graph {

		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; // Adjacency List

		// Constructor
		@SuppressWarnings("unchecked")
		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adj[i] = new LinkedList<>();
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
	private static void maximumEdgeAddtion(Graph graph) {

		// topological sort starts here
		boolean[] visited = new boolean[graph.adj.length];
		Stack<Integer> stack = new Stack<>();

		for (int vertex = 0; vertex < graph.V; vertex++) {
			if (!visited[vertex]) {
				topologicalSort(graph, vertex, visited, stack);
			}
		}

		System.out.println("Following is a Topological sort of the given graph");

		// topological sort ends here
		List<Integer> list = new ArrayList<>();

		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		System.out.println(list);

		printEdges(graph, list);
	}

	/**
	 * Print edge that can be added without breaking the DAG property.
	 * 
	 * @param graph
	 * @param list
	 */
	private static void printEdges(Graph graph, List<Integer> list) {

		int count = 0;

		boolean[] visited = new boolean[graph.V];

		// looping for all nodes
		for (int i = 0; i < list.size(); i++) {

			int t = list.get(i);

			LinkedList<Integer> adj = graph.adj[t];

			// In below loop we mark the adjacent node of t
			for (int vertex : adj) {
				visited[vertex] = true;
			}

			// In below loop unmarked nodes are printed
			for (int j = i + 1; j < list.size(); j++) {
				// if not marked, then we can make an edge between t and j
				if (!visited[list.get(j)]) {
					System.out.println(t + "->" + list.get(j) + " ");
					count++;
				}

				visited[list.get(j)] = false;
			}
		}
		System.out.println("Total vertex " + count);
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
		graph.addEdge(3, 1);

		maximumEdgeAddtion(graph);
	}
}