package com.algorithmforum.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Function to print the left view of the Binary Tree.
 * 
 * https://www.geeksforgeeks.org/amazon-interview-experience-sde2/
 * 
 * @author rajesh.dixit
 * @since May 30, 2018 12:56:51 PM
 */
public class LeftViewBinaryTree {

	private static class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return String.valueOf(" " + data);
		}
	}

	/**
	 * Left View of Binary Tree
	 * 
	 * @param root
	 * @return
	 */
	private static List<Node> leftViewOfBinaryTree(Node root) {

		Queue<Node> queue = new LinkedList<>();
		List<Node> results = new LinkedList<>();

		queue.add(root);
		queue.add(null);

		boolean flag = true;
		while (!queue.isEmpty()) {

			Node node = queue.poll();
			if (node != null) {
				if (flag) {
					results.add(node);
					flag = flag ^ true;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else if (!queue.isEmpty()) {
				queue.add(null);
				flag = true;
			}
		}
		return results;
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		List<Node> leftViewBinaryTree = leftViewOfBinaryTree(root);

		System.out.println("Tree is perfect binary tree " + leftViewBinaryTree);
	}
}