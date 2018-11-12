package com.algorithmforum.search;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the array size ");
			int n = scan.nextInt();
			int[] array = new int[n];

			System.out.println("Enter the sorted array values ");
			for (int i = 0; i < array.length; i++) {
				array[i] = scan.nextInt();
			}

			System.err.println("Enter the value to search ");
			int val = scan.nextInt();

			int index = binarySearch(array, val);

			System.out.println("Index of value " + index);
		}
	}

	/**
	 * This is the binary search to find the element in sorted array.
	 * 
	 * @param array
	 * @param val
	 * @return
	 */
	private static int binarySearch(int[] array, int val) {
		int i = 0;
		int j = array.length;
		while (i < j) {
			int m = (i + j) / 2;
			if (array[m] > val) {
				j = m;
			} else if (array[m] == val) {
				return m;
			} else {
				i = m;
			}
		}
		return -1;
	}
}