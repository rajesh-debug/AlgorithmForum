package com.algorithmforum.dp;

/**
 * A k-palindrome string transforms into a palindrome on removing at most k
 * characters from it.
 * 
 * https://www.geeksforgeeks.org/find-if-string-is-k-palindrome-or-not/
 * 
 * @author rajesh.dixit
 */
public class KPalindrome {

	private static int isStringKPalidromeRecursion(String str, String rStr, int n, int m) {

		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}

		if (str.charAt(n) == rStr.charAt(m)) {
			return isStringKPalidromeRecursion(str, rStr, n - 1, m - 1);
		} else {
			return 1 + Math.min(isStringKPalidromeRecursion(str, rStr, n - 1, m),
					isStringKPalidromeRecursion(str, rStr, n, m - 1));
		}
	}

	private static int isStringKPalidromeDp(String str, String rStr, int n, int m) {

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (str.charAt(i	) == rStr.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}

		return dp[m][n];
	}

	/**
	 * Utility method to check whether the String is k palindrom or not.
	 * 
	 * @param str
	 * @param k
	 * @return
	 */
	private static boolean isStringKPalidromeRecursionUtil(String str, int k) {

		String rStr = new StringBuilder(str).reverse().toString();

		return isStringKPalidromeDp(str, rStr, str.length() - 1, rStr.length() - 1) <= 2 * k;
	}

	public static void main(String[] args) {
		String str = "acdgca";
		int k = 2;

		boolean kPalidrome = isStringKPalidromeRecursionUtil(str, k);

		System.out.println(" String is K palindrome " + kPalidrome);
	}
}
