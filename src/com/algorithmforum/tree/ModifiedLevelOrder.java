package com.algorithmforum.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ModifiedLevelOrder {

	private static class Node {
		public Node(int data) {
			this.data = data;
		}

		int data;
		Node left;
		Node right;
	}

	public static void main(String[] args) { // Constructing tree given in the above figure
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(3);
		root.left.right.right = new Node(1);
		root.right.left.left = new Node(4);
		root.right.left.right = new Node(2);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(2);
		root.left.right.left.left = new Node(16);
		root.left.right.left.right = new Node(17);
		root.right.left.right.left = new Node(18);
		root.right.right.left.right = new Node(19);

		printModifiedTraversal(root);
	}

	private static void printModifiedTraversal(Node root) {

		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		if (root == null) {
			return;
		}

		int count = 0;
		boolean r2l = false;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {

				Node node = queue.poll();
				if (!r2l) {
					System.out.print(" " + node.data);
				} else {
					stack.push(node);
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			System.out.println();
			if (r2l) {
				while (!stack.isEmpty()) {
					Node node = stack.pop();
					System.out.print(" " + node.data);
				}
			}
			if (count == 2) {
				r2l = !r2l;
				count = 0;
			}
		}
	}
}