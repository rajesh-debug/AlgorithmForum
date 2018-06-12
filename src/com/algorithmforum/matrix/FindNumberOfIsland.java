package com.algorithmforum.matrix;

public class FindNumberOfIsland {

	private static int ROWS;
	private static int COLS;
	
	private static int[] nbrRows = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int[] nbrCols = { -1, -1, -1, 0, 0, 1, 1, 1 };

	private static int getTotalIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		ROWS = matrix.length;
		COLS = matrix[0].length;
		int count = 0;
		boolean[][] visited = new boolean[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					// To mark visited, all nearest elements
					dfs(matrix, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * DFS to mark all neighbour element to visited.
	 * @param matrix
	 * @param visited
	 * @param row
	 * @param col
	 */
	private static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {
			int tRow = row + nbrRows[i];
			int tCol = col + nbrCols[i];
			if (isSafe(matrix, tRow, tCol, visited)) {
				dfs(matrix, visited, tRow, tCol);
			}
		}
	}

	/**
	 * Checking whether the neighbour element is safe
	 * @param matrix
	 * @param tRow
	 * @param tCol
	 * @param visited
	 * @return boolean value
	 */
	private static boolean isSafe(int[][] matrix, int tRow, int tCol, boolean[][] visited) {
		return tRow >= 0 && tRow < ROWS && tCol >= 0 && tCol < COLS && !visited[tRow][tCol] && matrix[tRow][tCol] == 1;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }
			};

		int totalIsland = getTotalIslands(matrix);
		System.out.println("Total number of islands: "+totalIsland);
	}
}