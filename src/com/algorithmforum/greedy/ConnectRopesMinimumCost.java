package com.algorithmforum.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Minimum cost required to connect the n pipes.
 * 
 * https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * 
 * @author rajesh.dixit
 */
public class ConnectRopesMinimumCost {

	/**
	 * Method which returns the minimum cost required to connect n pipes.
	 * 
	 * @param ropes
	 * @return minimum cost
	 */
	private static int getMinCost(int[] ropes) {

		int cost = 0;
		// Create a priority queue
		Queue<Integer> pq = new PriorityQueue<Integer>();

		for (Integer r : ropes) {
			pq.add(r);
		}

		while (pq.size() > 1) {
			// Fetch two minimum element from the queue.
			int f = pq.poll();
			int s = pq.poll();
			int newRope = f + s;
			cost = cost + newRope;
			pq.add(newRope);
		}
		return cost;
	}

	/**
	 * Driver class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ropes = { 4, 3, 2, 6 };

		int minCost = getMinCost(ropes);
		System.out.println(minCost);
	}
}