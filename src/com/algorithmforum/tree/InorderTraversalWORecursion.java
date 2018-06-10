package com.algorithmforum.tree;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * 
 * @author rajesh.dixit
 *
 */
public class InorderTraversalWORecursion {

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

	public static void main(String args[]) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		inorder(root);
	}

	private static void inorder(Node node) {

		Stack<Node> stack = new Stack<>();
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			Node n = stack.pop();
			System.out.print(n.data+" ");
			
			if (n.right != null) {
				node = n.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
}