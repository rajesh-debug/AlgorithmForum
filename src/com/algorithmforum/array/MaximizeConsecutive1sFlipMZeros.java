package com.algorithmforum.array;

/**
 * https://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 * 
 * @author rajesh.dixit
 */
public class MaximizeConsecutive1sFlipMZeros {

	/**
	 * This method returns maximum sequence after m flips.
	 * 
	 * @param array
	 * @param m
	 * @return max sequence length.
	 */
	private static int getMaxSequence(int[] array, int m) {
		int i = 0;
		int j = 0;
		int zeros = 0;
		int max = -1;
		int n = array.length;

		while (j < n && i < n) {

			while (zeros <= m && j < n) {
				if (array[j] == 0) {
					zeros++;
				}

				if (zeros > m) {
					break;
				}
				j++;
			}
			max = Math.max(max, j - i);

			while (zeros > m && i < j) {
				if (array[i] == 0) {
					zeros = zeros - 2;
				}
				i++;
			}
		}
		return max;
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean result = getMaxSequence(new int[] { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 }, 2) == 8
				&& getMaxSequence(new int[] { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 }, 1) == 5
				&& getMaxSequence(new int[] { 0, 0, 0, 1 }, 4) == 4;

		System.out.println("All tests have been passed " + result);
	}
}