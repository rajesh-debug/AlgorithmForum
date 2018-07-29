package com.algorithmforum.cci.stack;

import java.util.Stack;

@SuppressWarnings("hiding")
class MinStack<Integer> {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	/**
	 * While pushing the element in the Stack,
	 * 	1. In first stack, insert the element.
	 *  2. In second stack, insert minimum element from top and item to insert.
	 * 
	 * @param item
	 */
	public void push(Integer item) {
		stack1.push(item);
		if (stack2.isEmpty()) {
			stack2.push(item);
		} else {
			item = (int) item > (int) stack2.peek() ? stack2.peek() : item;
			stack2.push(item);
		}
	}

	/**
	 * Pop the top from both the stack while pop.
	 * 
	 * @return
	 */
	public Integer pop() {
		stack2.pop();
		return stack1.pop();
	}

	/**
	 * Return the peek of stack2 as Minimum element as we are tracking the Min element in stack 2.
	 * @return
	 */
	public Integer getMin() {
		return stack2.peek();
	}
}


/**
 * Tester class for the stack.
 * 
 * @author rajesh.dixit
 */
public class MinStackTest {

	public static void main(String[] args) {

		MinStack<Integer> minStack = new MinStack<>();

		System.out.println("Inserting elements in the stack: [4, 4, 3, 5, 7, 1]");
		minStack.push(4);
		minStack.push(4);
		minStack.push(3);
		minStack.push(5);
		minStack.push(7);
		minStack.push(1);

		System.out.println("Minimum element of Stack " + minStack.getMin());
		System.out.println("Pop the element from the stack " + minStack.pop());
		System.out.println("Minimum element of Stack " + minStack.getMin());
	}
}