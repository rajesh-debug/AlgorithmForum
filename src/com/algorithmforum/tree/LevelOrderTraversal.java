package com.algorithmforum.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 * @author rajesh.dixit
 *
 */
public class LevelOrderTraversal {

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

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node e = queue.poll();

			System.out.print(e.value + " ");
			if (e.left != null) {
				queue.add(e.left);
			}

			if (e.right != null) {
				queue.add(e.right);
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
