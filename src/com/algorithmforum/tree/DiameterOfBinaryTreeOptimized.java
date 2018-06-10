package com.algorithmforum.tree;

public class DiameterOfBinaryTreeOptimized {

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

	private static class Height {
		int h;
	}
	private static int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		Height lheight = new Height();
		Height rheight = new Height();

		int d = Math.max(lheight.h + rheight.h + 1, Math.max(diameter(node.left), diameter(node.right)));

		return d;
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
