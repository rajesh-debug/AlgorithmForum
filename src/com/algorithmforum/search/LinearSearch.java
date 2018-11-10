package com.algorithmforum.search;

public class LinearSearch {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 7, 6, 9, 10, 1, 8 };

		int val = 8;

		int index = searchElement(array, val);
		
		System.out.println("Index of value 8 is "+ index);
	}

	private static int searchElement(int[] array, int val) {
		for (int i = 0; i < array.length; i++) {
			if (val == array[i]) {
				return i;
			}
		}
		return -1;
	}
}