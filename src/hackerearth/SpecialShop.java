package hackerearth;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop-69904c91/
 * 
 * @author rajesh.dixit
 *
 */
public class SpecialShop {

	private static void printMinimumCost(int n, int a, int b) {

		double bn = (b * n);
		double p = Math.round(bn / (a + b));
		double x2 = Math.pow(p, 2);
		double y2 = Math.pow(n - p, 2);
		double min = a * x2 + b * y2;

		System.out.println((long) min);
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int N = scan.nextInt();

			for (int i = 0; i < N; i++) {
				int n = scan.nextInt();
				int a = scan.nextInt();
				int b = scan.nextInt();

				printMinimumCost(n, a, b);
			}
		}
	}
}