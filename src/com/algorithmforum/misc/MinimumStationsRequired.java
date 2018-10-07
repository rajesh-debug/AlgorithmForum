package com.algorithmforum.misc;

import java.util.Arrays;

/**
 * 
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * 
 * 
 * Given arrival and departure times of all trains that reach a railway station.
 * 
 * Find the minimum number of platforms required for the railway station so that no train waits.
 * 
 * Examples:
 * Input:
 * arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * 
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
 * @author rajesh.dixit
 */
public class MinimumStationsRequired {

	private static int findPlatform(int[] arr, int[] dep) {
		
		Arrays.sort(arr);
		Arrays.sort(dep);

		int i = 0;
		int j = 0;
		int n = arr.length;
		
		int pfCount = 0;
		int minPfCnt = 0;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				pfCount++;
				i++;
			} else if (pfCount > 0) {
				pfCount--;
				j++;
			}

			minPfCnt = Math.max(pfCount, minPfCnt);
		}
		return minPfCnt;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep));
	}
}