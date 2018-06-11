package com.algorithmforum.tree.todo;

/**
 *
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 * The idea of Morris Traversal is based on Threaded Binary Tree.
 * 
 * In this traversal, we first create links to Inorder successor and print the data using these links,
 * and finally revert the changes to restore original tree.
 *
 * 1. Initialize current as root 
 * 2. While current is not NULL 
 * 		If current does not have left child
 * 			a) Print current’s data
 * 			b) Go to the right, i.e., current = current->right
 * 		Else
 * 			a) Make current as right child of the rightmost node in current's left subtree
 * 			b) Go to this left child, i.e., current = current->left
 * 
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * 
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 * 
 * @author rajesh.dixit
 *
 */
public class InorderMorrisTraversal {

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
