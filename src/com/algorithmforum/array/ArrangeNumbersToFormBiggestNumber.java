package com.algorithmforum.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * 
 * @author rajesh.dixit
 */
public class ArrangeNumbersToFormBiggestNumber {

	/**
	 * Java 8 implementation.
	 * 
	 * @param arr
	 */
	private static void printLargestJava8(List<String> arr) {
		Comparator<String> comparator = (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2);

		Collections.sort(arr, comparator);

		System.out.print("\nJava 8 implementation: ");
		arr.forEach(System.out::print);
	}

	/**
	 * Before Java 8 implementation.
	 * 
	 * @param arr
	 */
	private static void printLargest(List<String> arr) {

		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;

				// Now see which of the two formed numbers is greater
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		System.out.print("Older version than Java 8: ");
		for (String val : arr) {
			System.out.print(val);
		}
	}

	public static void main(String[] args) {

		List<String> arr = new ArrayList<>();

		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		arr.add("9");
		arr.add("98");

		printLargest(arr);

		printLargestJava8(arr);

	}
}