package com.leetcode;

import java.util.Arrays;

public class P322_CoinChange {
	public int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];

		// Suppose, all coins of 1.
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = coin; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin] + 1);
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		System.out.println(new P322_CoinChange().coinChange(coins, 11));
		
	}
}
