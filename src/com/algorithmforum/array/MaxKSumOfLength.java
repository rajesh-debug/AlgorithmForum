package com.algorithmforum.array;

//A Java program to calculate max sum lengths of non overlapping contiguous subarrays with k as max element
// https://www.geeksforgeeks.org/maximum-sum-lengths-non-overlapping-subarrays-k-max-element/
public class MaxKSumOfLength {

	// Returns max sum of lengths with maximum element as k
	static int calculateMaxSumLength(int arr[], int k) {
		int n = arr.length;
		int lenSum = 0;
		int count = 0;
		boolean isFound = false;
		for (int i = 0; i < n;) {

			while (i < n && arr[i] <= k) {
				count++;
				if (!isFound) {
					isFound = arr[i] == k;
				}
				i++;
			}
			if (isFound) {
				lenSum = lenSum + count;
			}
			count = 0;
			isFound = false;

			while (i < n && arr[i] > k)
				i++;
		}
		return lenSum;
	}

	// driver program to test above method
	public static void main(String[] args) {

		int arr[] = { 4, 5, 7, 1, 2, 9, 8, 4, 3, 1 };

		int k = 4;
		int ans = calculateMaxSumLength(arr, k);
		System.out.println("Max Length :: " + ans);
	}
}