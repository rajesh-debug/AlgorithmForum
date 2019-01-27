package com.algorithmforum.array;

import java.util.Scanner;

/**
 * https://www.techiedelight.com/print-string-in-zig-zag-form-k-rows/
 * 
 * @author rajesh.dixit
 */
public class ZigZagNumbers {

	private static void printZigZagNumbers(int n, int k) {

		int tN = (n - 1) / k;
		tN = tN * k + 1;

		// print the first line
		int start = 1;

		for (int i = start; i <= tN; i += 2 * (k - 1)) {
			System.out.print(i + " ");
		}

		boolean up = true;
		for (int i = 1; i < k - 1; i++) {
			System.out.println();
			start++;
			for (int j = start; j < tN;) {

				System.out.print(j + " ");
				if (up) {
					j = j + (k - i - 1) * 2;
				} else {
					j = j + 2 * i;
				}
				up = up ^ true;
			}
		}

		System.out.println();
		for (int i = start + 1; i <= tN; i += 2 * (k - 1)) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int N = scan.nextInt();
			int k = scan.nextInt();
			printZigZagNumbers(N, k);
		}
	}
}