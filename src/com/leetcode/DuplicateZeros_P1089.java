package com.leetcode;

import java.util.Arrays;

public class DuplicateZeros_P1089 {

	public static void duplicateZeros(int[] arr) {

		int[] zeroCount = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			zeroCount[i] = (i > 0 ? zeroCount[i - 1] : 0);
			if (arr[i] == 0) {
				zeroCount[i]++;
			}
		}

		for (int i = arr.length - zeroCount[arr.length - 1]; i >= 0; i--) {
			if (arr[i] == 0) {
				arr[i + zeroCount[i]] = 0;
				arr[i + zeroCount[i] - 1] = 0;
			} else if (i + zeroCount[i] < arr.length) {
				arr[i + zeroCount[i]] = arr[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };

		duplicateZeros(array);
		System.out.println(Arrays.toString(array));
	}

}
