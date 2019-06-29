package com.algorithmforum.array;

import java.util.Arrays;

public class MissingElementsInArray {

	public static void main(String[] args) {

		int[] array = { 7, 8, 10, 100};

		Arrays.sort(array);

		int start = 0;
		int end = array[array.length - 1];
		int seq = array[start];

		while (start < end && seq < end) {
			if (array[start] == seq) {
				start++;
			} else {
				System.out.print(seq + " ");
			}
			seq++;
		}
	}
}