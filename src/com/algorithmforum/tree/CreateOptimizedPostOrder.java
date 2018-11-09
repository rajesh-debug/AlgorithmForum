package com.algorithmforum.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateOptimizedPostOrder {

	private static int preIdx = 0;

	private static void printPostUtil(int[] in, int[] pre, int start, int end) {

		if (start > end) {
			return;
		}

		/** Map to store the index of inorder elements array. */
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}

		printPost(in, pre, start, end, map);
	}

	private static void printPost(int[] in, int[] pre, int start, int end, Map<Integer, Integer> map) {

		if (start > end) {
			return;
		}

		int inIdx = map.get(pre[preIdx++]);

		printPost(in, pre, start, inIdx - 1, map);

		printPost(in, pre, inIdx + 1, end, map);

		System.out.print(in[inIdx] + " ");
	}

	public static void main(String ars[]) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		int len = in.length;
		printPostUtil(in, pre, 0, len - 1);
	}
}