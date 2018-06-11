package com.algorithmforum.dp;

/**
 * 
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * 
 * @author rajesh.dixit
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int maxWater = getMaxRainWater(arr);

		System.out.println(maxWater);
	}

	private static int getMaxRainWater(int[] arr) {

		int maxWater = 0;
		int maxLeft = 0;
		int maxRight = 0;
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {

			if (arr[lo] < arr[hi]) {
				if (maxLeft > arr[lo]) {
					maxWater += (maxLeft - arr[lo]);
				} else {
					maxLeft = arr[lo];
				}
				lo++;
			} else {
				if (maxRight > arr[hi]) {
					maxWater += (maxRight - arr[hi]);
				} else {
					maxRight = arr[hi];
				}
				hi--;
			}
		}

		return maxWater;
	}
}