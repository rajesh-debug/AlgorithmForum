package com.algorithmforum.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * This class represents a directed graph using adjacency list representation.
 * 
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
class GraphDFS {
	private int size;
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	GraphDFS(int v) {
		this.size = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	/** Function to add an edge into the graph. */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/**
	 * prints BFS traversal from a given source s
	 * 
	 * @param s
	 */
	void printBFS(int s) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[size];

		// Create a Stack to traverse elements
		Stack<Integer> stack = new Stack<Integer>();

		stack.add(s);
		visited[s] = true;

		while (!stack.isEmpty()) {

			// Pop a vertex from queue and print it
			int n = stack.pop();
			System.out.print(n + " ");

			// Get all adjacent vertices of the poped node and If a adjacent has not been
			// visited, then mark it visited and push it
			LinkedList<Integer> list = adj[n];
			for (Integer v : list) {
				if (!visited[v]) {
					stack.push(v);
					visited[v] = true;
				}
			}
		}

	}

	// Driver method to
	public static void main(String args[]) {
		GraphDFS g = new GraphDFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Breadth First Traversal " + "(starting from vertex 2)");

		g.printBFS(2);
	}
}