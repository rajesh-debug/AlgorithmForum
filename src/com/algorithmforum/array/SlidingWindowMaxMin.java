package com.algorithmforum.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * @author rajesh.dixit
 * @since Jun 13, 2018 12:15:32 PM
 */
public class SlidingWindowMaxMin {

	private static void printMax(int arr[], int k) {
		Deque<Integer> maxDeque = new LinkedList<>();
		Deque<Integer> minDeque = new LinkedList<>();

		/* To print the sum of max and min elements of k size window. */
		int sum = 0;

		/** Store maximum element of Window in the Queue. */
		for (int i = 0; i < k; i++) {
			while (!maxDeque.isEmpty() && arr[maxDeque.getLast()] < arr[i]) {
				maxDeque.removeLast();
			}

			while (!minDeque.isEmpty() && arr[minDeque.getLast()] > arr[i]) {
				minDeque.removeLast();
			}

			maxDeque.addLast(i);
			minDeque.addLast(i);
		}

		StringBuilder minSeq = new StringBuilder();
		StringBuilder maxSeq = new StringBuilder();
		for (int i = k; i < arr.length; i++) {
			sum = sum + arr[maxDeque.getFirst()] + arr[minDeque.getFirst()];

			/* printing the element of the window. */
			maxSeq.append(arr[maxDeque.getFirst()] + " ");

			minSeq.append(arr[minDeque.getFirst()] + " ");

			while (k <= i - maxDeque.getFirst()) {
				maxDeque.removeFirst();
			}

			while (k <= i - minDeque.getFirst()) {
				minDeque.removeFirst();
			}

			while (!maxDeque.isEmpty() && arr[maxDeque.getLast()] <= arr[i]) {
				maxDeque.removeLast();
			}

			while (!minDeque.isEmpty() && arr[minDeque.getLast()] >= arr[i]) {
				minDeque.removeLast();
			}

			maxDeque.addLast(i);
			minDeque.addLast(i);
		}

		maxSeq.append(arr[maxDeque.peek()] + " ");
		minSeq.append(arr[minDeque.peek()] + " ");

		sum = sum + arr[maxDeque.peek()] + arr[minDeque.peek()];

		System.out.println("Sum of Max and min elements is " + sum);

		System.out.println("Min window: " + minSeq);

		System.out.println("Max window: " + maxSeq);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
		int k = 3;
		printMax(arr, k);
	}
}