package com.algorithmforum.bitwise;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * https://codeforces.com/blog/entry/2154
 * 
 * https://discuss.codechef.com/questions/112461/how-to-find-xor-of-all-the-elements-in-given-range
 * 
 * https://stackoverflow.com/questions/10670379/find-xor-of-all-numbers-in-a-given-range
 * 
 * @author rajesh.dixit
 */
public class BitXOR {

	/**
	 * In this approach, we are figure out the pattern.
	 * 
	 * @param M
	 * @param N
	 * @return
	 */
	public static int solution1(int M, int N) {

		int patterns[];

		if (M % 2 == 0) {
			patterns = new int[] { N, 1, N ^ 1, 0 };
		} else {
			patterns = new int[] { M, M ^ N, M - 1, (M - 1) ^ N };
		}

		return patterns[(N - M) % 4];
	}

	/**
	 * Solution using loop based approach.
	 * 
	 * Assumption: (4*K) * (4*K+1) * (4*K+2) * (4*K+3) = 0
	 * 
	 * @param M
	 * @param N
	 * @return
	 */
	public static int solution2(int M, int N) {

		// XOR product of numbers.
		int XOR = 0;

		while (M <= N) {
			int x = (N - M) / 4;
			/**
			 * To skip the sequences which follow the assumptions:
			 * (4*K)*(4*K+1)*(4*K+2)*(4*K+3) = 0.
			 */
			if (x != 0 && M % 4 == 0 && M + 4 * x <= N) {
				M = M + 4 * x;
			} else {
				XOR = XOR ^ M;
				M = M + 1;
			}
		}

		return XOR;
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("Please enter the numbers : ");
			int M = scan.nextInt();
			int N = scan.nextInt();
			int result1 = solution1(M, N);
			int result2 = solution2(M, N);

			System.out.println("Result1 " + result1);
			System.out.println("Result2 " + result2);

			// testBothMethod();
		}
	}

	public static void testBothMethod() {
		boolean flag = true;
		System.out.print("Processing...");
		for (int i = 0; i < 1000000; i++) {
			Random rand = new Random();
			int M = rand.nextInt(10000);
			int N = rand.nextInt() + M;

			if (M < N) {
				if (solution1(M, N) != solution2(M, N)) {
					flag = false;
					System.out.println("Mismatched calculated value of Method 1 and Method 2 " + M + " " + N);
				} else {
					System.out.print(".");
				}
			}
		}

		if (flag) {
			System.out.println("\nBoth the Methods are working fine");
		}
	}
}