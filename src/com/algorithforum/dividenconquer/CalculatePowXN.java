package com.algorithforum.dividenconquer;

public class CalculatePowXN {

	/**
	 * Calculate the n power of x
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 * 
	 * @param x
	 * @param n
	 * @return pow
	 */
	private static int calculatePow(int x, int n) {
		if (n == 0) {
			return 1;
		}

		if (n % 2 == 1) {
			return x * calculatePow(x, n / 2) * calculatePow(x, n / 2);
		} else {
			return calculatePow(x, n / 2) * calculatePow(x, n / 2);
		}
	}

	/**
	 * Calculate the n power of x
	 * 
	 * Space Complexity: O(1) Time Complexity: O(logn) optimized to O(logn) by
	 * calculating power(x, y/2) only once and storing it.
	 * 
	 * @param x
	 * @param n
	 * @return pow
	 */
	private static int calculatePowOptimized(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int t = calculatePow(x, n / 2);
		if (n % 2 == 1) {
			return x * t * t;
		} else {
			return t * t;
		}
	}

	/**
	 * Calculate the n power of x
	 * 
	 * Space Complexity: O(1) Time Complexity: O(logn) optimized to O(logn) by
	 * calculating power(x, y/2) only once and storing it.
	 * 
	 * @param x
	 * @param n
	 * @return pow
	 */
	private static double calculateNegativePowUtil(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int pow = calculatePowOptimized(x, Math.abs(n));
		if (n < 0) {
			return 1.0 / pow;
		}
		return pow;
	}

	public static void main(String[] args) {

		int x = 3;

		int n = 7;

		int pow = calculatePow(x, n);

		System.out.println(String.format(" %d power of %d = %d", n, x, pow));

		pow = calculatePowOptimized(x, n);

		System.out.println(String.format(" %d power of %d = %d", n, x, pow));

		double pow1 = calculateNegativePowUtil(2, -4);

		System.out.println(String.format(" %d power of %d = %f", n, x, pow1));
	}

}
