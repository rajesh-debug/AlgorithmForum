package com.algorithmforum.flipkart.set48;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderProblem {
	public static void main(String[] args) {

		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
		int min = getMinDiceThrows(moves);

		System.out.println(min);

	}

	private static class Position {
		int position;
		int distance;

		public Position(int position, int distance) {
			this.position = position;
			this.distance = distance;
		}
	}

	private static int getMinDiceThrows(int[] moves) {
		boolean[] visited = new boolean[30];
		visited[0] = true;
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0));

		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int node = position.position;
			int dist = position.distance;

			for (int i = node + 1; i <= node + 6 && i < moves.length; i++) {

				if (i == moves.length - 1) {
					return dist + 1;
				}

				if (!visited[i]) {
					Position position1 = new Position(moves[i] == -1 ? i : moves[i], dist + 1);
					queue.add(position1);
					visited[i] = true;
				}
			}

		}
		return 0;
	}

}
