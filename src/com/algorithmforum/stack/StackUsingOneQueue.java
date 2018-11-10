package com.algorithmforum.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a stack using single Queue.
 * 
 * https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
 * 
 * @author rajesh.dixit
 */
public class StackUsingOneQueue {

	private static class MyStack {

		private int MAX_SIZE;

		private Queue<Integer> queue;


		public MyStack(int size) {
			this.MAX_SIZE = size;
			queue = new LinkedList<Integer>();
		}

		public int size() {
			return queue.size();
		}

		public boolean isFull() {
			return MAX_SIZE < queue.size();
		}

		public Integer poll() {
			if (queue.isEmpty()) {
				return -1;
			}
			return queue.remove();
		}

		public Integer peek() {
			if (queue.isEmpty()) {
				return -1;
			}
			return queue.peek();
		}

		public Integer push(Integer item) {
			if (isFull()) {
				throw new StackOverflowError("Stack is full");
			}
			int size = queue.size();
			queue.add(item);
			while (size-- > 0) {
				int itm = queue.poll();
				queue.add(itm);

			}
			return item;
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		@Override
		public String toString() {
			return queue.toString();
		}
	}

	public static void main(String[] args) {

		MyStack myStack = new MyStack(8);
		myStack.push(3);
		myStack.push(5);
		myStack.push(2);
		myStack.push(1);
		myStack.push(1);
		myStack.push(-1);

		System.out.println("Size of the stack " + myStack.size());
		while (!myStack.isEmpty()) {
			int item = myStack.poll();
			System.out.print(" " + item);
		}
	}
}