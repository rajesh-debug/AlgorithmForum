package com.algorithmforum.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * This algorithm is a variant of Depth-first search. In depth first search, we
 * first print the vertex and then go to its neighbours but in case of
 * topological sort, we don’t print vertex immediately instead we push it to the
 * Stack.
 * 
 * In topological sorting, we will have a temporary stack. We are not going to
 * print the vertex immediately, we first recursively call topological sorting
 * for all its neighbour vertices, then push it to a stack. We will print stack
 * once we are done with recursive topolgical sorting.
 * 
 * Why it works? It works because when you push any node to stack, you have
 * already pushed its neighbours (and their neighbours and so on),so node which
 * does not have any dependency will be on the top of stack. In our case, we
 * will have 40 on top of the stack.
 * 
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