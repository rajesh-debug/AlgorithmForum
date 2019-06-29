package com.algorithmforum.matrix;

/**
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * @author rajesh.dixit
 */
public class SpiralMatrix {

	/**
	 * Method to print the spiral matrix.
	 * 
	 * @param array
	 * @param r
	 * @param c
	 */
	private static void spiralPrint(int[][] array, int r, int c) {

		int m = 0, n = 0;
		c--; r--;
		
		while (m <= r && n <= c) {

			for (int i = n; i <= c; i++) {
				System.out.print(array[m][i] + " ");
			}
			m++;

			for (int j = m; j <= r; j++) {
				System.out.print(array[j][c] + " ");
			}
			c--;

			if (r > m) {
				for (int i = c; i >= n; i--) {
					System.out.print(array[r][i] + " ");
				}
				r--;
			}

			if (c > n) {
				for (int j = r; j >= m; j--) {
					System.out.print(array[j][n] + " ");
				}
				n++;
			}
		}
	}

	/** Driver program. */
	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int array[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 }};
		
		spiralPrint(array, R, C);
	}
}