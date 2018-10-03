package com.algorithmforum.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajesh.dixit
 * 
 * @since Sep 11, 2018 12:42:46 PM
 */
public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int rank;

		@Override
		public String toString() {
			return String.format("[ Data: %l, Parent: %l, Rank: %d ]", data, parent.data, rank);
		}
	}

	/**
	 * Make set with Rank 0, self as parent.
	 * 
	 * @param data
	 */
	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}

	/**
	 * Union two nodes.
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean union(long v1, long v2) {

		Node node1 = map.get(v1);
		Node node2 = map.get(v2);

		return linkNodes(node1, node2);
	}

	/**
	 * Link two nodes.
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private boolean linkNodes(Node node1, Node node2) {

		Node parent1 = findSetRep(node1);
		Node parent2 = findSetRep(node2);

		if (parent2.rank > parent1.rank) {
			parent1.parent = parent2;
		} else {
			parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		}
		return true;
	}

	/**
	 * Find representative set data.
	 * 
	 * @param data
	 * @return
	 */
	public long findSet(long data) {
		return findSetRep(map.get(data)).data;
	}

	/**
	 * Method to find the parent or representative of subset.
	 * 
	 * @param node
	 * @return representative of element set
	 */
	private Node findSetRep(Node node) {
		Node parent = node.parent;
		if (node == parent) {
			return parent;
		}
		node.parent = findSetRep(node.parent);

		return node.parent;
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));
	}
}