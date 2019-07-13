package com.algorithmforum.tree;

import java.util.Stack;

public class CreatePreOrderRecusion {

	private static int postIdx;

	private static Stack<Integer> stack = new Stack<>();

	/**
	 * Print post order.
	 * 
	 * @param in
	 * @param post
	 * @param start
	 * @param end
	 */
	private static void printPostOrder(int[] in, int[] post, int start, int end) {

		if (start > end) {
			return;
		}

		int inIdx = search(in, start, end, post[postIdx--]);

		printPostOrder(in, post, inIdx + 1, end);

		printPostOrder(in, post, start, inIdx - 1);

		stack.add(in[inIdx]);
	}

	/**
	 * This method returns the index in the inorder traversal.
	 * 
	 * @param in
	 * @param start
	 * @param end
	 * @param val
	 * @return return index in order traversal.
	 */
	private static int search(int[] in, int start, int end, int val) {
		int j = 0;
		for (j = start; j < end; j++) {
			if (in[j] == val) {
				break;
			}
		}
		return j;

	}
	
	/**
	 * Print stack.
	 */
	private static void printStack() {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String ars[]) {
		// int pre[] = { 1, 2, 4, 5, 3, 6 };
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int post[] = { 4, 5, 2, 6, 3, 1 };
		
		int len = in.length;
		postIdx = len - 1;
		
		printPostOrder(in, post, 0, len - 1);
		
		printStack();
	}
}