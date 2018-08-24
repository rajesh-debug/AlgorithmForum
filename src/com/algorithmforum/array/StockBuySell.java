package com.algorithmforum.array;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

	private static class Pair {
		int buyIdx;
		int sellIdx;
	}

	public static void main(String args[]) {
		// stock prices on consecutive days
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };

		// function call
		stockBuySell(price);
	}

	private static void stockBuySell(int[] prices) {

		if (prices == null || prices.length <= 2) {
			return;
		}
		int n = prices.length;
		List<Pair> list = new ArrayList<>();
		int i = 0;
		int count = 0;
		while (i < n - 1) {

			Pair pair = new Pair();
			/** Increase the index for till find Minima. */
			while (i < n - 1 && prices[i + 1] < prices[i]) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			pair.buyIdx = i++;

			/** Find Local Maxima. */
			while ((i < n) && (prices[i] >= prices[i - 1])) {
				i++;
			}

			// Store the index of maxima
			pair.sellIdx = i - 1;
			list.add(pair);
			count++;
		}

		// print solution
		if (count == 0) {
			System.out.println("There is no day when buying the stock " + "will make profit");
		} else {
			for (int j = 0; j < count; j++) {
				System.out.println("Buy on day: " + list.get(j).buyIdx + "  " + "Sell on day : " + list.get(j).sellIdx);
			}
		}
	}
}
