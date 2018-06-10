package com.algorithmforum.tree;

public class DiameterOfBinaryTree {

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

	private static int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lheight = height(node.left);
		int rheight = height(node.right);

		int d = Math.max(lheight + rheight + 1, Math.max(diameter(node.left), diameter(node.right)));

		return d;
	}

	private static int height(Node node) {
		if (node == null) {
			return 0;
		}
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("The diameter of given binary tree is : " + diameter(root));
	}
}
