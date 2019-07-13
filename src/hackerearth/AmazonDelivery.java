package hackerearth;

import java.util.LinkedList;
import java.util.Queue;

public class AmazonDelivery {

	class Node {
		int row;
		int col;
		int dist;

		Node(int x, int y, int w) {
			row = x;
			col = y;
			dist = w;
		}
	}

	int minimumDistance(int r, int c, int grid[][]) {

		boolean visited[][] = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 0)
					visited[i][j] = true;
				else
					visited[i][j] = false;

			}
		}

		// applying BFS on matrix cells starting from source
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Node p = q.poll();

			// Destination found;
			if (grid[p.row][p.col] == 9)
				return p.dist;

			// moving up
			if (p.row - 1 >= 0 && visited[p.row - 1][p.col] == false) {
				q.add(new Node(p.row - 1, p.col, p.dist + 1));
				visited[p.row - 1][p.col] = true;
			}

			// moving down
			if (p.row + 1 < r && visited[p.row + 1][p.col] == false) {
				q.add(new Node(p.row + 1, p.col, p.dist + 1));
				visited[p.row + 1][p.col] = true;
			}

			// moving left
			if (p.col - 1 >= 0 && visited[p.row][p.col - 1] == false) {
				q.add(new Node(p.row, p.col - 1, p.dist + 1));
				visited[p.row][p.col - 1] = true;
			}

			// moving right
			if (p.col + 1 < c && visited[p.row][p.col + 1] == false) {
				q.add(new Node(p.row, p.col + 1, p.dist + 1));
				visited[p.row][p.col + 1] = true;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int grid[][] = { { 0, 1, 0, 0 }, { '*', '0', '*', '*' }, { '0', '*', '*', '*' },
				{ 'd', '*', '*', '*' } };

		int d = new AmazonDelivery().minimumDistance(4, 4, grid);

		System.out.println(d);
	}

}