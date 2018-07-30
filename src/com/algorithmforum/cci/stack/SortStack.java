package com.algorithmforum.cci.stack;

import java.util.Stack;

/**
 * Sort a stack in Java.
 * 
 * @author rajesh.dixit
 */
public class SortStack {

	private static void sortStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<>();

		while (!stack.isEmpty()) {
			int item = stack.pop();
			while (!temp.isEmpty() && item < temp.peek()) {
				stack.push(temp.pop());
			}
			temp.push(item);
		}

		stack.addAll(temp);
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(4);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		stack.push(11);
		stack.push(21);
		stack.push(6);
		stack.push(18);

		System.out.println("Inserting elements in the stack: " + stack);

		sortStack(stack);

		System.out.println("Sorted stack: " + stack);
	}
}