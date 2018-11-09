package com.algorithmforum.matrix;

import java.util.Stack;

/**
 * In a party of N people, only one person is known to everyone. Such a person
 * may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 * We can only ask questions like "Does A know B?"
 * 
 * Find the stranger (celebrity) in minimum number of questions.
 * 
 * 
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * @author rajesh.dixit
 */
public class CelebrityProblem {

	private static int[][] MATRIX = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	/**
	 * Check the in-degree of every node in graph. If it is greater equals to total
	 * node -1, It is celebrity.
	 * 
	 * We can model the solution using graphs. Initialize in degree and out degree
	 * of every vertex as 0. If A knows B, draw a directed edge from A to B,
	 * increase in degree of B and out degree of A by 1.
	 * 
	 * @return celebrity.
	 */
	private static void printCelebrityUsingGraph() {
		int celebrity = -1;
		int len = MATRIX.length;

		int[] inDegree = new int[len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (knows(i, j)) {
					inDegree[j] = inDegree[j] + 1;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			if (inDegree[i] >= len - 1) {
				celebrity = i;
				break;
			}
		}

		System.out.println("Celebrity is(Graph method)#" + celebrity);
	}

	/**
	 * If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
	 * If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be
	 * celebrity. Repeat above two steps till we left with only one person. Ensure
	 * the remained person is celebrity.
	 **/
	private static void printCelebrityUsingStack() {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < MATRIX.length; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			int i = stack.pop();
			int j = stack.pop();

			if (knows(i, j)) {
				stack.push(j);
			} else if (knows(j, i)) {
				stack.push(i);
			}
		}

		int celebrity = stack.pop();
		System.out.println("Celebrity is(Stack method)#" + celebrity);
	}

	/**
	 * Print celebrity using two pointers.
	 */
	private static void printCelebrityUsingTwoPointers() {

		int a = 0;
		int b = MATRIX.length - 1;

		while (a < b) {
			if (knows(a, b)) {
				a++;
			} else {
				b--;
			}
		}

		for (int i = 0; i < MATRIX.length; i++) {
			if (i != a && (knows(a, i) || !knows(i, a))) {
				a = -1;
				break;
			}
		}

		System.out.println("Celebrity is(Two Pointers)#" + a);
	}

	/**
	 * Check that a knows b.
	 * 
	 * @param a
	 * @param b
	 * @return true/false
	 */
	private static boolean knows(int a, int b) {
		return MATRIX[a][b] == 1;
	}

	/**
	 * Driver method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		printCelebrityUsingGraph();

		printCelebrityUsingStack();

		printCelebrityUsingTwoPointers();
	}
}