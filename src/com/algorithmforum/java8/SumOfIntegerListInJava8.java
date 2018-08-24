package com.algorithmforum.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfIntegerListInJava8 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 4, 3, null);

		int sum = list.stream().filter(x -> x != null).mapToInt(x -> x.intValue()).sum();
		System.out.println(sum);

		int[] array = new int[Integer.MAX_VALUE];
		Arrays.fill(array, Integer.MAX_VALUE);
		list = new ArrayList<>();
		System.out.println(list);
		long sum1 = list.stream().filter(x -> x != null).mapToLong(x -> x.intValue()).sum();
		System.out.println(sum1);
	}
}
