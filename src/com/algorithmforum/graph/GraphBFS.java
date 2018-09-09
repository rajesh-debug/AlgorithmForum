package com.algorithmforum.graph;

import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * 
 * This class represents a directed graph using adjacency list representation.
 */
class GraphBFS {
	private int size;
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	GraphBFS(int v) {
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

		// Create a queue to traverse elements
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			int n = queue.poll();
			System.out.print(n + " ");

			// Get all adjacent vertices of the dequeued node and If a adjacent has not been
			// visited, then mark it visited and enqueue it
			LinkedList<Integer> list = adj[n];
			for (Integer v : list) {
				if (!visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
		}

	}

	// Driver method to
	public static void main(String args[]) {
		GraphBFS g = new GraphBFS(4);

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