package com.dp;

public class SubsetSumProblem {

	private static boolean isSumSubsetExist(int[] array, int sum) {
		int col = sum+1;
		int row = array.length+1;
		boolean[][] dp = new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<col;i++) {
			dp[0][i] = false;
		}
		
		for (int i = 1; i < row; i++) {
			int value = array[i-1];
			/* Create DP. */
			for (int j = 1; j < col; j++) {
				if(j<value) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j-value];
				}
			}
		}
		
		/** Print the elements set. */
		printElements(dp, array, row, col);
		
		return dp[row-1][col-1];
	}
	
	private static void printElements(boolean[][] dp, int[] array, int row, int col) {
		int i = row-1; int j = col-1;
		
		while(i>0 && j>=0) {
			int value = array[i-1];
			if(j-value>=0 && dp[i-1][j-value]) {
				i = i -1;
				j = j-value;
				System.out.println(value);
			} else {
				i--;
			}	
		}
	}

	/**
	 * Driver Method
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {3, 12, 4, 12, 5, 2};
		int sum = 7;
		boolean isExist = isSumSubsetExist(array,sum);
		System.out.println(isExist);
	}
}