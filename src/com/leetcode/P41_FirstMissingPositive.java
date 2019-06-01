package com.leetcode;

public class P41_FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {

		// Set all negative numbers to Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (num <= nums.length && num != Integer.MAX_VALUE) {
				nums[num-1] = -1 * nums[num-1];
			}
		}

		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i+1;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		new P41_FirstMissingPositive().firstMissingPositive(nums);
	}

}
