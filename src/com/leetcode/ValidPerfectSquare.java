package com.leetcode;

public class ValidPerfectSquare {

	public static boolean judgeSquareSum(int c) {
		int a = (int) Math.sqrt(c);

		for (int i = a; i >= 0; i--) {
			double b = Math.sqrt(c - i * i);

			if (b == (int) b) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		boolean res = judgeSquareSum(1000);

		System.out.println(res);
	}

}
