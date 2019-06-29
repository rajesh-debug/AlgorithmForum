package com.algorithmforum.list;

/**
 * To Do.
 * 
 * There are two linked lists. Both linked lists have a single-digit number in
 * their nodes. I needed to treat this linked lists as a numbers and add them up
 * and store the digits in a new linked list.
 * E.g.
 * head -> 5 -> 6 -> 7-> 9
 * head -> 2-> 1 -> 1
 * Resultant linked list:
 * head-> 5 -> 8-> 9-> 0 (5679 + 211 = 5890)
 * 
 * @author rajesh.dixit
 *
 */
public class NumberListSum {

	private static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private static int getSumOfLists(Node l1, Node l2) {

		// Reverse list l1
		reverseList(l1);

		// Reverse list l2
		reverseList(l2);

		// Sum of lists

		return 0;
	}

	private static void reverseList(Node node) {

		/* Function to reverse the linked list */
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;

	}

	public static void main(String[] args) {
		Node l1 = new Node(5);
		l1.next = new Node(6);
		l1.next.next = new Node(7);
		l1.next.next.next = new Node(9);

		Node l2 = new Node(2);
		l2.next = new Node(1);
		l2.next.next = new Node(1);

		int sum = getSumOfLists(l1, l2);

		System.out.printf(" Sum of the list is %d", sum);
	}

}
