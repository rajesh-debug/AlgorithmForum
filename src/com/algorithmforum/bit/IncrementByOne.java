package com.algorithmforum.bit;

public class IncrementByOne {
	public static void main(String[] args) {
		int value = 20;
		value = increment(20);
		System.out.println(value);
	}

	private static int increment(int number) {
		int one = 1;

		/* Flip all the set bits until we find a 0 */
		while ((number & one) != 0) {
			number = number ^ one;
			one <<= 1;
		}

		/* flip the rightmost 0 bit */
		number = number ^ one;
		return number;
	}
}