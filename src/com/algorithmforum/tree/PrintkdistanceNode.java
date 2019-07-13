package com.algorithmforum.tree;

/**
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * 
 * @author rajesh.dixit
 */
public class PrintkdistanceNode {
	/*
	 * Class containing left and right child of current node and key value
	 */
	private static class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/**
	 * This method is used to print all down nodes at k distance from root.
	 * 
	 * @param target
	 * @param d
	 */
	private static void printDownNodes(Node target, int d) {

		if (target == null || d < 0) {
			return;
		}
		if (d == 0) {
			System.out.print(target.data + " ");
			return;
		}

		printDownNodes(target.left, d - 1);
		printDownNodes(target.right, d - 1);
	}

	private static void printkdistanceNode(Node root, Node target, int d) {

	}

	/**
	 * Utility to print all Nodes which are k distance away.
	 * 
	 * @param root
	 * @param target
	 * @param d
	 */
	private static void printkdistanceNodeUtil(Node root, Node target, int d) {

		printDownNodes(target, d);

		if (target == root) {
			printkdistanceNode(root, target, d);
		}
	}

	public static void main(String args[]) {

		/* Let us construct the tree shown in above diagram */
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.left.right.left.right = new Node(34);
		Node target = root.left.right;
		printkdistanceNodeUtil(root, target, 2);
	}
}
