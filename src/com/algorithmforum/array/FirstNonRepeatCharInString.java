package com.algorithmforum.array;

import java.util.Arrays;

public class FirstNonRepeatCharInString {

	/**
	 * This method returns the first non-repeat element of the string.
	 * 
	 * @param str
	 * @return
	 */
	private static void printFirstNonRepeatChar(String str) {

		int n = str.length();

		int[] ch = new int[26];
		Arrays.fill(ch, -1);

		for (int i = 0; i < n; i++) {
			int c = str.charAt(i) - 'a';
			if (ch[c] == -1) {
				ch[c] = i;
			} else if (ch[c] >= 0) {
				ch[c] = -2;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (ch[i] >= 0) {
				System.out.println("First non-repeat character " + str.charAt(ch[i]));
				return;
			}
		}

		System.out.println("No such character found !");
	}
	
	public static void main(String[] args) {
		String str = "algorithmforumalgorithm";

		printFirstNonRepeatChar(str);
	}
}