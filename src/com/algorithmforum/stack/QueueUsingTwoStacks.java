package com.algorithmforum.stack;

import java.util.Stack;

public class QueueUsingTwoStacks {

	private static class MyQueue {
		private Stack<Integer> stack1;
		private Stack<Integer> stack2;

		public MyQueue() {
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}

		/**
		 * Pushing the element in the Queue.
		 * 
		 * @param item
		 */
		public void push(Integer item) {
			stack1.push(item);
		}

		/**
		 * Pop the top from both the stack while pop.
		 * 
		 * @return
		 */
		public Integer pop() {
			int item = -1;
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			item = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return item;
		}
		
		/**
		 * Peek the top from both the stack while peek.
		 * 
		 * @return
		 */
		public Integer peek() {
			int item = -1;
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			item = stack2.peek();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return item;
		}
	}
	
	public static void main(String[] args) {

		MyQueue myQueue = new MyQueue();

		System.out.println("Inserting elements in the Queue: [4, 11, 3, 5, 7, 1]");
		myQueue.push(4);
		myQueue.push(11);
		myQueue.push(3);
		myQueue.push(5);
		myQueue.push(7);
		myQueue.push(1);

		System.out.println("Pop the element from the Queue " + myQueue.pop());
		
		System.out.println("Inserting elements in the Queue: [8]");
		myQueue.push(8);
		
		System.out.println("Pop the element from the Queue " + myQueue.pop());
	}
}
