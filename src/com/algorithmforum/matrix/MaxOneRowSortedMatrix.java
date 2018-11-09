package com.algorithmforum.matrix;

public class MaxOneRowSortedMatrix {

	/**
	 * Row with maximum number of ones.
	 * 
	 * https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
	 * 
	 * @param mat
	 * @return row num.
	 */
	private static int getRowWithMaxOnes(int[][] mat) {

		int n = mat.length;
		int j = 0;
		int maxRowIdx = 0;

		for (int i = 0; i < n; i++) {
			if (mat[0][i] == 0) {
				j++;
			}
		}

		for (int i = 1; i < n; i++) {
			while (j >= 0 && mat[i][j] == 1) {
				j--;
				maxRowIdx = i;
			}

		}
		return maxRowIdx;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };

		int row = getRowWithMaxOnes(matrix);

		System.out.println(row);
	}
}