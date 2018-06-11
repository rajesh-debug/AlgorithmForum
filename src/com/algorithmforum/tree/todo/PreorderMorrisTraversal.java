package com.algorithmforum.tree.todo;

/**
 * 
 * https://www.geeksforgeeks.org/morris-traversal-for-preorder/
 * 
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 * 
 * @author rajesh.dixit
 *
 */
public class PreorderMorrisTraversal {

	// A binary tree node
	private static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

		@Override
		public String toString() {
			return data + "";
		}
	}

	private static Node root;

	private static void morrisTraversalPreorder() {
		morrisTraversalPreorder(root);
	}

	// Preorder traversal without recursion and without stack
	private static void morrisTraversalPreorder(Node node) {
		while (node != null) {

			// If left child is null, print the current node data. Move to
			// right child.
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {

				// Find inorder predecessor
				Node current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}

				// If the right child of inorder predecessor already points to this node
				if (current.right == node) {
					current.right = null;
					node = node.right;
				}

				// If right child doesn't point to this node, then print this node and make right child point to this node
				else {
					System.out.print(node.data + " ");
					current.right = node;
					node = node.left;
				}
			}
		}
	}

	// Driver programs to test above functions
	public static void main(String args[]) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		morrisTraversalPreorder();
		System.out.println("");
	}
}