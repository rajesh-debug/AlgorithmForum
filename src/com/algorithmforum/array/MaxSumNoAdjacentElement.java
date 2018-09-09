package com.algorithmforum.array;

public class MaxSumNoAdjacentElement {

	/**
	 * Method to return the maximum sum
	 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	 * @return Max sum
	 */
	private static int getMaxSum(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}

		int currInc = array[0];
		int currExc = 0;
		int exclNew = 0;

		for (int i = 1; i < array.length; i++) {

			exclNew = (currInc > currExc) ? currInc : currExc;

			currInc = currExc + array[i];
			currExc = exclNew;
		}

		return Math.max(currInc, currExc);
	}

	/**
	 * Method to return the maximum sum
	 * https://www.youtube.com/watch?v=UtGtF6nc35g
	 * @return Max sum
	 */
	private static int getMaxSum1(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}

		int currInc = array[0];
		int currExc = 0;
		int temp = 0;

		for (int i = 1; i < array.length; i++) {

			temp = currInc;

			currInc = Math.max(currExc + array[i], currInc);
			currExc = temp;
		}
		return Math.max(currInc, currExc);
	}

	/**
	 * Driver method.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 5, 5, 10, 100, 10, 5 };

		int maxSum = getMaxSum(array);

		System.out.println("1. Max sum without adjacent element " + maxSum);

		maxSum = getMaxSum1(array);

		System.out.println("2. Max sum without adjacent element " + maxSum);
	}
}