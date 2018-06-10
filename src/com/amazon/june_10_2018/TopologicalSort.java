package com.amazon.june_10_2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://java2blog.com/topological-sort-java/
 * 
 * @author rajesh.dixit
 *
 */
public class TopologicalSort {
	Stack<Node> stack;
	Set<Node> visited;

	public TopologicalSort() {
		stack = new Stack<>();
		visited = new HashSet<Node>();

	}

	static class Node {
		int data;
		List<Node> neighbours;

		Node(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();

		}

		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}

		public String toString() {
			return "" + data;
		}
	}

	private void toplogicalSort(Node node) {
		List<Node> neighbours = node.neighbours;

		for (Node tNode : neighbours) {
			if (!visited.contains(tNode)) {
				visited.add(tNode);
				toplogicalSort(tNode);
			}
		}
		stack.add(node);
	}

	public static void main(String arg[]) {

		TopologicalSort topological = new TopologicalSort();
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);

		System.out.println("Topological Sorting Order:");
		topological.toplogicalSort(node40);

		// Print contents of stack
		Stack<Node> resultStack = topological.stack;
		while (resultStack.empty() == false) {
			System.out.print(resultStack.pop() + " ");
		}
	}
}