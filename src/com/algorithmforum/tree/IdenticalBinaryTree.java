package com.algorithmforum.tree;

/*** Java program to see if two trees are identical.  */

//A binary tree node 
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class IdenticalBinaryTree {
	private static Node root1, root2;

	/*
	 * Given two trees, return true if they are structurally identical
	 */
	private static boolean identicalTrees(Node a, Node b) {

		/** Terminating condition: when current of both tree are null. */
		if (a == null && b == null) {
			return true;
		} else if (a != null && b != null) {
			/** If both the nodes are not null, call further recursion. */
			return a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right);
		}
		
		/* Returns false is non of above conditions is matched. */
		return false;
	}

	/* Driver program to test identicalTrees() function */
	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		if (identicalTrees(root1, root2)) {
			System.out.println("Both trees are identical");
		} else {
			System.out.println("Trees are not identical");
		}
	}
}