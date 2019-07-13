package com.leetcode;

import java.util.Arrays;

public class RemoveDuplicationValue {

	/**
	 * This method removes duplicates and return the index till non-duplicate
	 * element are exits.
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {

		if (nums == null) {
			return 0;
		} else if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int c = 0;
		for (int j = 0; j < nums.length; j++) {
			if (val == nums[j]) {
				c++;
			}
		}

		int i = 0;
		int j = 1;

		while (i < nums.length) {
			if (i + c < nums.length && nums[i] == val) {
				while (j < nums.length && nums[j] == val) {
					j++;
				}
				nums[i] = nums[j];
				nums[j] = val;
			}
			i++;
			j = i + 1;
		}

		return nums.length - c;
	}

	/**
	 * Test method to remove duplicates.
	 * 
	 */
	private static void testRemoveDuplicates() {

		int[] array = { 0, 1, 2, 2, 3, 0, 4, 2, 2 };

		int[] resultArray = { 0, 1, 3, 0, 4 };

		int eIdx = removeElement(array, 2);

		if (Arrays.equals(resultArray, Arrays.copyOfRange(array, 0, eIdx))) {
			System.out.println("Tests are passed");
		} else {
			System.err.println("Tests are failed");
		}
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		testRemoveDuplicates();
	}
}