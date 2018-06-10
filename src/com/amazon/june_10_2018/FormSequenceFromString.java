package com.amazon.june_10_2018;

import java.util.Stack;

public class FormSequenceFromString {

	public static void main(String[] args) {
		String str = "abc";
		String sequence = "aabcbabcc";

		boolean result = isSequenceFormedUsingStringNoRepeatingChar(str, sequence);
		System.out.println("Non repeating sequence " + result);
	}

	private static boolean isSequenceFormedUsingStringNoRepeatingChar(String str, String sequence) {
		int length = str.length();

		Stack<Character> stack = new Stack<>();
		for (Character ch : sequence.toCharArray()) {
			int index = length - 1;
			stack.push(ch);
			while (index >= 0 && stack.peek() == str.charAt(index)) {
				stack.pop();
				index--;
			}
		}
		return stack.size() == 0;
	}

}
