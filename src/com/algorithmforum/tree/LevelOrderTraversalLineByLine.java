package com.algorithmforum.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
 * 
 * @author rajesh.dixit
 *
 */
public class LevelOrderTraversalLineByLine {

	/*
	 * Class containing left and right child of current node and key value
	 */
	private static class Node {
		int value;
		Node left, right;

		public Node(int item) {
			value = item;
			left = right = null;
		}
	}

	private static void printLevelOrder(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node e = queue.poll();

			if (e == null) {
				System.out.println();
				queue.add(null);
			} else {
				System.out.print(e.value + " ");
				if (e.left != null) {
					queue.add(e.left);
				}

				if (e.right != null) {
					queue.add(e.right);
				}
			}

			if (queue.peek() == null && queue.size() == 1) {
				break;
			}

		}

	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("The Level order traversal of given binary tree is : ");
		printLevelOrder(root);
	}
}
