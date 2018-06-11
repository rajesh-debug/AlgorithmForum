package com.algorithmforum.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Create an array sum[] where sum[i] stores sum(arr[0]+..arr[i]).
 * Create a hash table having tuple as (Rrem, idx), where rem represents an element of (sum[i] % k)
 * 		and idx represents the element’s index of first occurrence when array
 * 
 * sum[] is being traversed from left to right.
 * 
 * Now traverse sum[] from i = 0 to n and follow the steps given below.
 * 		Calculate current remainder as curr_rem = sum[i] % k. If curr_rem == 0,
 * 
 * 	    if maxSum < sum[i], update maxSum = sum[i]. Else if curr_rem is not
 * 			present in the hash table, then create tuple (curr_rem, i) in the hash table.
 * 		Else if, get the value associated with curr_rem in the hash table.
 * 			Let this be idx. Now, if maxSum < (sum[i] – sum[idx])
 * 				then update maxSum = sum[i] – sum[idx].
 * 
 * Finally, return (maxSum / k).
 * https://www.geeksforgeeks.org/maximum-number-chocolates-distributed-equally-among-k-students/
 * 
 * @author rajesh.dixit
 *
 */
public class MaximumNumberChocolates {

	public static void main(String[] args) {
		int[] array = { 2, 7, 6, 1, 4, 5 };

		int k = 3;
		int maxChocs = getMaximumNumberOfChocsDistributedEqually(array, k);

		System.out.println(maxChocs);
	}

	private static int getMaximumNumberOfChocsDistributedEqually(int[] array, int k) {

		int[] sum = new int[array.length];
		sum[0] = array[0];
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			sum[i] = array[i] + sum[i - 1];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < sum.length; i++) {
			int rem = sum[i] % k;

			if (rem == 0) {
				max = Math.max(max, sum[i] / k);
			} else if (map.containsKey(rem)) {
				max = Math.max(max, (sum[i] - sum[map.get(rem)]) / k);
			} else {
				map.put(rem, i);
			}
		}
		return max;
	}
}