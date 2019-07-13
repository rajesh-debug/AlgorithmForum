package com.leetcode;

import java.util.PriorityQueue;

public class MaxProfit {

	PriorityQueue<String> pQueue = new PriorityQueue<String>();

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}

		int maxProfit = 0;
		int b = 0;
		int s = 0;
		if (prices[1] > prices[0]) {
			b = prices[0];
		}
		for (int i = 1; i < prices.length - 1; i++) {
			if (prices[i] <= prices[i - 1] && prices[i] <= prices[i + 1]) {
				b = prices[i];
			} else if (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
				s = prices[i];
				maxProfit = maxProfit + s - b;
				b = 0;
				s = 0;
			}
		}

		if (b > 0) {
			maxProfit = maxProfit + prices[prices.length - 1] - b;
		}
		return maxProfit;
	}
}