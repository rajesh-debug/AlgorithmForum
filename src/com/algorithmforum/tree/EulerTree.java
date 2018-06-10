package com.algorithmforum.tree;

import java.util.ArrayList;
import java.util.List;

public class EulerTree {

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
		root.right.left.right = new Node(8);

		// print Euler Tour
		printEulerTour(root);
	}

	// Find Euler Tour
	private static void eulerTree(Node root, List<Integer> euler) {
		// store current node's data
		euler.add(root.data);

		// If left node exists
		if (root.left != null) {
			// traverse left subtree
			eulerTree(root.left, euler);

			// store parent node's data
			euler.add(root.data);
		}

		// If right node exists
		if (root.right != null) {
			// traverse right subtree
			eulerTree(root.right, euler);

			// store parent node's data
			euler.add(root.data);
		}
	}

	// Function to print Euler Tour of tree
	private static  void printEulerTour(Node root) {
		// Stores Euler Tour
		List<Integer> euler = new ArrayList<>();

		eulerTree(root, euler);

		for (int i = 0; i < euler.size(); i++) {
			System.out.print(euler.get(i)+" ");
		}
	}

}