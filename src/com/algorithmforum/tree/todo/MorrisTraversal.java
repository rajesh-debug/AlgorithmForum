package com.algorithmforum.tree.todo;

public class MorrisTraversal {

	private static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static void inorder(Node root) {
		Node current = root;
		while (current != null) {
			// left is null then print the node and go to right
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				// find the predecessor.
				Node predecessor = current.left;
				// To find predecessor keep going right till right node is not null or right
				// node is not current.
				while (predecessor.right != current && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				// if right node is null then go left after establishing link from predecessor
				// to current.
				if (predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				} else { // left is already visit. Go right after visiting current.
					predecessor.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public static void main(String args[]) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(0);
		root.left.left = new Node(-10);
		root.left.right = new Node(11);
		inorder(root);
	}

}
