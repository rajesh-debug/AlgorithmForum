package com.leetcode;

public class AddBinaryP_67 {
	public String addBinary(String a, String b) {
		StringBuilder s = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;
		int c = 0;

		while (i >= 0 || j >= 0) {

			int a1 = 0;
			if (i >= 0) {
				a1 = a.charAt(i--) - '0';
			}

			int b1 = 0;
			if (j >= 0) {
				b1 = b.charAt(j--) - '0';
			}

			int nc = a1 + b1 + c;
			s.append(nc % 2);
			c = nc / 2;
		}

		if (c == 1) {
			s.append(c);
		}

		return s.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinaryP_67 addBinaryP_67 = new AddBinaryP_67();
		String binarySum = addBinaryP_67.addBinary("1010", "1011");

		System.out.println(binarySum);
	}
}
