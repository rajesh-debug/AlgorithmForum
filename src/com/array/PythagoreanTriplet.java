package com.array;

import java.util.Arrays;

public class PythagoreanTriplet {

	/**
	 * Pythagorean Triplet Exist
	 * 
	 * @param arr
	 * @return
	 */
	private static boolean isPythagoreanTripletExists(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				// A triplet found
				if (arr[l] + arr[r] == arr[i]) {
					return true;
				} else if (arr[l] + arr[r] < arr[i]) { // Else either move 'l' or 'r'
					l++;
				} else {
					r--;
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 6, 5 };
		boolean exists = isPythagoreanTripletExists(arr);
		System.out.println(exists);
	}
}