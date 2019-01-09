package com.algorithmforum.array;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * We are getting one bit(0/1) per second. Find the number of 1's in last one
 * minute in any instant.
 * 
 * 
 * Note: In the code, we are checking for 5 elements only.
 * 
 * 1 0 1 0 1 1 1 1 1 1 1 1 1 1 0 0 0 1 1
 * 
 * @author rajesh.dixit
 */
public class NumberOfOnesInLastOneMinute {

	public static void main(String[] args) throws IOException {

		try (Scanner scan = new Scanner(System.in)) {
			int count = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			while (true) {
				int n = scan.nextInt();
				int polledElement = 0;
				if (queue.size() == 5) {
					polledElement = queue.poll();
				}

				queue.add(n);

				count = count - polledElement + n;
				System.out.println("Element in last 1 min are " + count);
			}
		}
	}
}