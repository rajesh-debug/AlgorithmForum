package hackerearth;

import java.util.*;

public class NearestRestaurent {
	static class Node implements Comparable<Node> {
		double dist;
		private List<Integer> list;

		public List<Integer> getList() {
			return list;
		}

		Node(double dist, List<Integer> nodes) {
			this.dist = dist;
			this.list = nodes;
		}

		@Override
		public int compareTo(Node node) {
			return (node.dist - this.dist) > 0.0 ? -1 : 1;
		}

	}

	List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants, List<List<Integer>> allLocations,
			int numRestaurants) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		for (List<Integer> vertex : allLocations) {
			int a = vertex.get(0);
			int b = vertex.get(1);
			double dist = Math.sqrt(a * a + b * b);
			Node n = new Node(dist, vertex);
			queue.add(n);
		}

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRestaurants; i++) {
			list.add(queue.poll().getList());

		}

		return list;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(1, -3));
		list.add(Arrays.asList(1, 2));
		list.add(Arrays.asList(3, 4));

		NearestRestaurent sol = new NearestRestaurent();
		list = sol.nearestVegetarianRestaurant(3, list, 1);

		System.out.println(list);

	}
}