package com.algorithmforum.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * @author rajesh.dixit
 * @since Jun 13, 2018 12:15:32 PM
 */
public class SlidingWindowMaximum {

	private static void printMax(int arr[], int k) {
		Deque<Integer> deque = new LinkedList<>();

		/** Store maximum element of Window in the Queue. */
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		for (int i = k; i < arr.length; i++) {
			/* printing the element of the window. */
			System.out.println(arr[deque.getFirst()]);

			while (k <= i - deque.getFirst()) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
				deque.removeLast();
			}

			deque.addLast(i);
		}

		System.out.println(arr[deque.peek()]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		printMax(arr, k);
	}
}
