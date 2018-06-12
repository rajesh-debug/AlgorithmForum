package com.algorithmforum.matrix;

public class LargestRegionInMatrix {

	private static int ROWS;
	private static int COLS;
	
	private static int[] nbrRows = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int[] nbrCols = { -1, -1, -1, 0, 0, 1, 1, 1 };

	private static int getLargestRegion(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		ROWS = matrix.length;
		COLS = matrix[0].length;
		boolean[][] visited = new boolean[ROWS][COLS];
		int largestRegion = Integer.MIN_VALUE;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					// To mark visited, all nearest elements
					int region = dfs(matrix, visited, i, j) + 1;
					largestRegion = Math.max(region, largestRegion);
				}
			}
		}
		return largestRegion;
	}

	/**
	 * DFS to mark all neighbour element to visited.
	 * 
	 * @param matrix
	 * @param visited
	 * @param row
	 * @param col
	 * @param count
	 */
	private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {
			int tRow = row + nbrRows[i];
			int tCol = col + nbrCols[i];
			if (isSafe(matrix, tRow, tCol, visited)) {
				return 1 + dfs(matrix, visited, tRow, tCol);
			}
		}
		return 0;
	}

	/**
	 * Checking whether the neighbour element is safe
	 * 
	 * @param matrix
	 * @param tRow
	 * @param tCol
	 * @param visited
	 * @return boolean value
	 */
	private static boolean isSafe(int[][] matrix, int tRow, int tCol, boolean[][] visited) {
		return tRow >= 0 && tRow < ROWS && tCol >= 0 && tCol < COLS && !visited[tRow][tCol] && matrix[tRow][tCol] == 1;
	}
	
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }
			};

		int largestRegion = getLargestRegion(matrix);
		System.out.println("Largest Region: "+largestRegion);
	}
}