package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56_MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0 || intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // increased sort by start
		// System.out.println(list);

		List<int[]> mergeList = new ArrayList<>();
		mergeList.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			int[] i1 = mergeList.get(mergeList.size() - 1);
			int[] i2 = intervals[i];

			if (i1[1] >= i2[0]) {
				i1[1] = Math.max(i1[1], i2[1]);
			} else {
				mergeList.add(i2);
			}
		}

		int[][] array = new int[mergeList.size()][2];
		int i = 0;
		for (int[] m : mergeList) {
			array[i][0] = m[0];
			array[i][1] = m[1];
			i++;
		}
		return array;
	}
}