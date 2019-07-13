package com.leetcode;

import java.util.Arrays;

public class RemoveDuplication {

	/**
	 * This method removes duplicates and return the index till non-duplicate
	 * element are exits.
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		} else if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int i = 0;
		int j = 1;
		int len = nums.length;

		while (i < len && j < len) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				nums[++i] = nums[j++];
			}
		}

		return i + 1;
	}

	/**
	 * Test method to remove duplicates.
	 * 
	 */
	private static void testRemoveDuplicates() {

		int[] array = { 1, 2, 2, 3, 4, 5, 5 };

		int[] resultArray = { 1, 2, 3, 4, 5 };

		int eIdx = removeDuplicates(array);

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