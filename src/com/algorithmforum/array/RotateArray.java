package com.algorithmforum.array;

public class RotateArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 2;

		rotateArray(array, k);

		printArray(array);
	}

	private static void rotateArray(int[] array, int k) {
		int n = array.length;

		// Reverse the array
		int i = 0;
		int j = n - 1;
		while (i < j) {
			swap(array, i, j);
			i++;
			j--;
		}
		// array = { 7, 6, 5, 4, 3, 2, 1 }

		// Reverse the two sub arrays.
		i = 0;
		j = k - 1;
		while (i < j) {
			swap(array, i, j);
			i++;
			j--;
		}

		i = k;
		j = n - 1;
		while (i < j) {
			swap(array, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void printArray(int[] array) {
		for (int val : array) {
			System.out.print(val + " ");
		}
	}
}
