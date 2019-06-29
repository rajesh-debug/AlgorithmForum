package com.algorithmforum.array;

import java.util.Scanner;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
 * convention, 1 is included.
 * 
 * Given a number n, the task is to find n’th Ugly number.
 * https://www.geeksforgeeks.org/ugly-numbers/
 * 
 * @author rajesh.dixit
 *
 */
public class PrintNUglyNumbers {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter the count ");
			int n = scan.nextInt();

			int[] ugly = new int[n];
			ugly[0] = 1;
			int i2 = 0, i3 = 0, i5 = 0;
			int v2 = 2;
			int v3 = 3;
			int v5 = 5;

			for (int i = 1; i < n; i++) {
				int num = min(v2, v3, v5);
				ugly[i] = num;

				if (num == v2) {
					i2++;
					v2 = ugly[i2] * 2;
				}
				if (num == v3) {
					i3++;
					v3 = ugly[i3] * 3;
				}
				if (num == v5) {
					i5++;
					v5 = ugly[i5] * 5;
				}
			}

			System.out.println(ugly[n - 1]);
		}
	}

	private static int min(int v2, int v3, int v5) {
		return Math.min(Math.min(v2, v3), v5);
	}
}
