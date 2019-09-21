package com.algorithmforum.codeforces;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * http://codeforces.com/problemset/problem/1176/B
 * 
 * @author rajesh.dixit
 */
public class MergeIt {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		try (Scanner reader = new Scanner(System.in)) {
			int N = reader.nextInt();
			for (int i = 0; i < N; i++) {
				int n = reader.nextInt();
				Map<Integer, Integer> map = new HashMap<>();
				for (int j = 0; j < n; j++) {
					int value = reader.nextInt() % 3;
					map.put(value, 1 + map.getOrDefault(value, 0));
				}
				sb.append(getMergeCount(map)).append("\n");
			}

			System.out.println(sb.toString());
		}
	}

	/**
	 * @param map
	 * @return
	 */
	private static int getMergeCount(Map<Integer, Integer> map) {
		int count = map.getOrDefault(0, 0);
		int count1 = map.getOrDefault(1, 0);
		int count2 = map.getOrDefault(2, 0);
		return count + Math.min(count1, count2) + Math.abs(count1 - count2) / 3;
	}
}