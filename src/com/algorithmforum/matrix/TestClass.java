package com.algorithmforum.matrix;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

public class TestClass {
	private static int ROW;
	private static int COL;

	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	static void diagonalOrder(int matrix[][]) {

		boolean flip = false;
		Stack<Integer> stack = new Stack<>();

		for (int line = 1; line <= (ROW + COL - 1); line++) {

			int start_col = Math.max(0, line - ROW);

			int count = min(line, (COL - start_col), ROW);

			// Print elements of this line
			for (int j = 0; j < count; j++) {
				if (flip) {
					stack.push(matrix[Math.min(ROW, line) - j - 1][start_col + j]);
				} else {
					System.out.print(matrix[Math.min(ROW, line) - j - 1][start_col + j] + " ");
				}
			}

			if (flip) {
				printStack(stack);
			}
			flip = flip ^ true;
		}
	}

	private static void printStack(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	// Driver code
	public static void main(String[] args) {
		int[][] M = null;
		try (Scanner scan = new Scanner(System.in)) {
			ROW = scan.nextInt();
			COL = scan.nextInt();
			M = new int[ROW][COL];
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					M[i][j] = scan.nextInt();
				}
			}
		}

		diagonalOrder(M);
	}
}