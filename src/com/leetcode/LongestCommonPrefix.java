package com.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "aaa", "aa", "aaa" };
		longestCommonPrefix(strs);
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0 || strs[0].length() == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}

		int len = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			len = Math.min(len, strs[i].length());
		}

		char[] str1 = strs[0].toCharArray();
		int index = 0;
		for (int i = 1; i < strs.length; i++) {
			char[] str2 = strs[i].toCharArray();
			index = 0;
			while (index < str1.length && str1[index] != '@') {
				if (index >= str2.length || str1[index] != str2[index]) {
					str1[index] = '@';
					break;
				} else if (str1[index] == str2[index]) {
					index++;
				}
			}
		}
		return index > 0 ? strs[0].substring(0, index) : "";

	}
}