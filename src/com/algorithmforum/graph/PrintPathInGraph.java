package com.algorithmforum.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a directed graph using adjacency list representation
 * 
 * @author rajesh.dixit
 */
class PrintPathInGraph {

	// No. of vertices
	private int v;
	private boolean[] isVisited;

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	PrintPathInGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}

		isVisited = new boolean[v];
	}

	// Method to add an edge into the graph
	void addEdge(int v, int w) {
		// Add w to v's list.
		adj[v].add(w);
	}

	/**
	 * This recursive method is used to count the total no of paths from s to d.
	 * 
	 * @param s
	 * @param d
	 * @param integers
	 * @param count
	 * @return no of paths from s to u.
	 */
	private int countPaths(int s, int d, List<Integer> integers, int count) {

		isVisited[s] = true;
		integers.add(s);

		if (s == d) {
			System.out.println(integers);
			integers.clear();
			count++;
		} else {
			List<Integer> adjList = adj[s];
			for (int node : adjList) {
				if (!isVisited[node]) {
					count = countPaths(node, d, integers, count);
				}
			}
		}
		integers.clear();
		isVisited[s] = false;
		return count;
	}

	// Driver Code
	public static void main(String args[]) {

		PrintPathInGraph g = new PrintPathInGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		int s = 2, d = 3;

		int count = 0;
		List<Integer> integers = new ArrayList<>();
		count = g.countPaths(s, d, integers, 0);
		
		System.out.println(count);
	}
}