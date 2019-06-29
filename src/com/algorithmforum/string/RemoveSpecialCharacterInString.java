package com.algorithmforum.string;

public class RemoveSpecialCharacterInString {

	public static void main(String[] args) {
		String str = "Rajesh #$2Kumar_1424";

		removeSpecialCharacter(str);
	}

	private static void removeSpecialCharacter(String str) {

		String str1 = "";

		for (int i = 0; i < str.length(); i++) {
			int ascii = Character.toLowerCase(str.charAt(i));
			if ((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57)) {
				str1 = str1 + str.charAt(i);
			}
		}
		System.out.println(str1);
	}
}