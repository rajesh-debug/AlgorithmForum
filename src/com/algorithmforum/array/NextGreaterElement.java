package com.algorithmforum.array;

import java.util.Stack;

/**
 * Next greater element of the array. Given an array, print the Next Greater
 * Element (NGE) for every element. The Next greater Element for an element x is
 * the first greater element on the right side of x in array. Elements for which
 * no greater element exist, consider next greater element as -1.
 * 
 * Examples: [4, 5, 2, 25]
 * 
 * 4 --> 5 5 --> 25 2 --> 25 25 --> -1
 * 
 * https://www.geeksforgeeks.org/next-greater-element/
 * 
 * @author rajesh.dixit
 */
public class NextGreaterElement {


	/**
	 * This method prints Next greater element of each element.
	 * 
	 * @param array
	 * @param n
	 */
	private static void printNextGreaterElements(int[] array, int n) {
		Stack<Integer> maxStack = new Stack<>();
		int[] nge = new int[n];

		for (int i = array.length - 1; i >= 0; i--) {

			// Remove all elements from the stack which are smaller than current element.
			while (!maxStack.isEmpty() && maxStack.peek() <= array[i]) {
				maxStack.pop();
			}

			// if stack is empty, no NGE exists, else stack peek will be NGE.
			nge[i] = maxStack.isEmpty() ? -1 : maxStack.peek();

			// Push the current element on the top of the stack.
			maxStack.add(array[i]);
		}

		for (int val : nge) {
			System.out.print(val + " ");
		}
	}
	
	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 4, 5, 7, 8, 4, 2, 25 };

		printNextGreaterElements(array, array.length);
	}
}