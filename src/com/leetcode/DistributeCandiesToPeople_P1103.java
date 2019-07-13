package com.leetcode;

public class DistributeCandiesToPeople_P1103 {

	public static void main(String[] args) {
		distributeCandies(60, 4);
	}

	public static int[] distributeCandies(int candies, int p) {

		int n = (int) (Math.sqrt(1 + 8 * candies) - 1) / (2 * p);
		int i = 0;
		int[] dCandies = new int[p];
		if (n > 0) {
			for (i = 1; i <= dCandies.length; i++) {
				dCandies[i - 1] = (n * (2 * i + (n - 1) * p)) / 2;
				candies -= dCandies[i - 1];
			}
		}

		int d = n * p + 1;

		i = 0;
		while (candies > 0) {
			dCandies[i % p] = dCandies[i % p] + (candies > d ? d : candies);
			candies -= d;
			d++;
			i++;
		}

		return dCandies;
	}
}
