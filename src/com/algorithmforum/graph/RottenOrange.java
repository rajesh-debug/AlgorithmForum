package com.algorithmforum.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Rotten orange problem
 * 
 * https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 * 
 * @author rajesh.dixit
 */
public class RottenOrange {

	private static Vertex delimiter = new Vertex(-1, -1);

	/**
	 * Class to store the index of rotten
	 */
	private static class Vertex {
		public int x;
		public int y;

		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Vertex v = ((Vertex) obj);
			return this.x == v.x && this.y == v.y;
		}

		@Override
		public String toString() {
			return "(" + x + " , " + y + ")";
		}
	}

	/**
	 * This method return total rotten orange.
	 * 
	 * @param arr
	 * @return no of rotten orange
	 */
	private static int rotOranges(int[][] arr) {

		Deque<Vertex> queue = new LinkedList<>();

		int unrotted = 0;
		int count = 0;

		// Push the rot orange in Queue and count the orange to be rotten.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					queue.add(new Vertex(i, j));
				} else if (arr[i][j] == 1) {
					unrotted++;
				}
			}
		}

		/** put delimiter in the queue. */
		queue.add(delimiter);

		while (!queue.isEmpty() && !delimiter.equals(queue.peek()) && unrotted > 0) {
			unrotted = bfs(queue, unrotted, arr);
			count++;
		}

		return unrotted <= 0 ? count : -1;
	}

	/**
	 * BFS to rot all oranges.
	 * 
	 * @param queue
	 * @param unrotted
	 * @param arr
	 * @return
	 */
	private static int bfs(Deque<Vertex> queue, int unrotted, int[][] arr) {

		Vertex v1 = queue.pollFirst();

		while (v1 != null && !delimiter.equals(v1) && unrotted > 0) {
			for (int i = v1.x - 1; i <= v1.x + 1; i++) {
				for (int j = v1.y - 1; j <= v1.y + 1; j++) {
					if (isValid(arr, v1, i, j) && arr[i][j] == 1) {
						queue.add(new Vertex(i, j));
						arr[i][j] = 3;
						unrotted--;
					}
				}
			}

			if (queue.peekLast().equals(delimiter)) {
				break;
			}
			
			v1 = queue.pollLast();
		}

		return unrotted;
	}

	/**
	 * To check the element is valid in the matrix.
	 * 
	 * @param arr
	 * @param v1
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean isValid(int[][] arr, Vertex v1, int i, int j) {
		int I = arr.length;
		int J = arr[0].length;
		int X = v1.x;
		int Y = v1.y;

		return i >= 0 && j >= 0 && i < I && j < J && !(X == i + 1 && Y == j + 1);
	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		int ans = rotOranges(arr);

		if (ans == -1) {
			System.out.println("All oranges cannot rot");
		} else {
			System.out.println("Time required for all oranges to rot = " + ans);
		}
	}
}