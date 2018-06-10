package com.algorithmforum.matrix;

import java.util.Stack;

public class PrintMatrixDiagonallyZigzag {

	private static int ROW = 5;
	private static int COL = 4;

	// Utility function to print a matrix
	static void printMatrix(int matrix[][]) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}

	private static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < ROW && c < COL;
	}

	private static void diagonalOrder(int[][] m) {
		boolean flip = false;
		Stack<Integer> stack = new Stack<>();
		// print first set.
		for (int i = 0; i < ROW; i++) {
			int r = i;
			int c = 0;
			while (isValid(r, c)) {
				if (flip) {
					stack.push(m[r][c]);
				} else {
					System.out.printf("%s ", m[r][c]);
				}
				r--;
				c++;
			}
			while (flip && !stack.isEmpty()) {
				System.err.printf("%s ", stack.pop());
			}
			flip = !flip;
			System.out.println();
		}

		// print first set.
		for (int i = 1; i < COL; i++) {
			int r = ROW - 1;
			int c = i;
			while (isValid(r, c)) {
				if (flip) {
					stack.push(m[r][c]);
				} else {
					System.out.printf("%s ", m[r][c]);
				}
				r--;
				c++;
			}
			while (flip && !stack.isEmpty()) {
				System.err.printf("%s ", stack.pop());
			}
			flip = !flip;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int M[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		System.out.print("Given matrix is \n");
		printMatrix(M);

		System.out.print("\nDiagonal printing of matrix is \n");
		diagonalOrder(M);
	}
}