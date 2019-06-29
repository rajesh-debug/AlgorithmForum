package com.algorithmforum.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringMaxDistinctChar {

	/**
	 * Get minimum length.
	 * 
	 * @param input
	 * @return minimum length
	 */
	private static int getMinLen(String input) {
		if (input == null || input.trim().isEmpty()) {
			return -1;
		}

		Map<Character, Integer> map = new HashMap<>();

		for (char c : input.toCharArray()) {
			Integer count = map.get(c);
			if (count == null) {
				count = 0;
			}
			map.put(c, count + 1);
		}

		// Exclude the left side elements
		int i = 0;
		while (true) {
			char c = input.charAt(i);
			if (map.get(c) == 1) {
				break;
			} else {
				map.put(c, map.get(c) - 1);
			}
			i++;
		}

		// Exclude the right side element.
		int j = input.length() - 1;
		while (true) {
			char c = input.charAt(j);
			if (map.get(c) == 1) {
				break;
			} else {
				map.put(c, map.get(c) - 1);
			}
			j--;
		}

		return j - i + 1;
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean result = getMinLen("GEEKSGEEKSFOR") == 8 && getMinLen("AABBBCBB") == 5 && getMinLen("AABBBCBBAC") == 3;

		System.out.printf("All tests are passed %b ", result);
	}
}