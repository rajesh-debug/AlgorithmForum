package com.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * 
 * @author rajesh.dixit
 *
 */
public class LongestSubstringRepeatingCharacters {

	/**
	 * Longest Unique Substring
	 * 
	 * @param str
	 * @return
	 */
	private static int longestUniqueSubstring(String str) {
		Map<Character, Integer> charIdxMap = new HashMap<>();
		int length = str.length();
		int maxLngth = 1;
		int count = 1;
		for (int i = 1; i < length; i++) {
			char ch = str.charAt(i);
			int prev = charIdxMap.get(ch) == null ? -1 : charIdxMap.get(ch);
			if (prev == -1 || i - prev > count) {
				count++;
			} else {
				maxLngth = Math.max(maxLngth, count);
				count = i - prev;
			}
			charIdxMap.put(ch, i);
		}
		return maxLngth;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeksgeeksforgeyuieks";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubstring(str);
		System.out.println("The length of " + "the longest non repeating character is " + len);
	}
}