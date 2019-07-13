package com.algorithmforum.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountEven {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		
		Long count = list.stream().filter(i -> i % 2 == 0).collect(Collectors.counting());
		System.out.println("Even number in the list are:" + count);
	}
}
