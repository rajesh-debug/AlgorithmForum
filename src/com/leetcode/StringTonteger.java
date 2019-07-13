package com.leetcode;

import java.util.Stack;

public class StringTonteger {

	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}

	public static boolean isValid(String s) {
		if (s == null || s.trim().isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}  else if (stack.size()>0 && ((c == ')' && stack.peek() == '(') ||
                        (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{'))) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
