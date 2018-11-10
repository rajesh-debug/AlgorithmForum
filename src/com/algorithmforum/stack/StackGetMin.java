package com.algorithmforum.stack;

import java.util.Stack;
import java.util.concurrent.ExecutionException;

/**
 * 
 * Design a SpecialStack that supports all the stack operations like push(),
 * pop(), isEmpty(), isFull() and an additional operation getMin() which should
 * return minimum element from the SpecialStack.
 * 
 * All these operations of SpecialStack must be O(1).
 * 
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 * @author rajesh.dixit
 */
public class StackGetMin {

	private static class MyStack {

		private int MAX_SIZE;

		private Stack<Integer> stack;

		private Integer minItem;

		public MyStack(int size) {
			this.MAX_SIZE = size;
			stack = new Stack<Integer>();
		}

		public int size() {
			return stack.size();
		}

		public boolean isFull() {
			return MAX_SIZE < stack.size();
		}

		public Integer pop() {
			int item = stack.pop();
			if (minItem.compareTo(item) > 0) {
				item = 2 * minItem - item;
				minItem = item;
			}
			return item;
		}

		public Integer peek() {
			return stack.peek();
		}

		public Integer push(Integer item) {
			if (isFull()) {
				throw new StackOverflowError("Stack is full");
			}
			int val = item;
			if (minItem == null) {
				minItem = item;
			} else if (minItem.compareTo(item) > 0) {
				val = 2 * item - minItem;
				minItem = item;
			}
			return stack.push(Integer.valueOf(val));
		}

		public Integer getMin() {
			int item = stack.peek();
			if (minItem.compareTo(item) < 0) {
				item = 2 * minItem - item;
			}
			return item;
		}

		public boolean isEmpty() {
			return stack.isEmpty();
		}

		@Override
		public String toString() {
			return stack.toString();
		}
	}

	public static void main(String[] args) {

		MyStack myStack = new MyStack(4);
		myStack.push(3);
		myStack.push(5);
		myStack.push(2);
		myStack.push(1);
		myStack.push(1);
		myStack.push(-1);

		System.out.println("Size of the stack " + myStack.size());
		while (!myStack.isEmpty()) {
			int item = myStack.getMin();
			myStack.pop();
			System.out.print(" " + item);
		}
	}
}