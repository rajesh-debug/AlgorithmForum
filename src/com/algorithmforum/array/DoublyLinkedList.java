package com.algorithmforum.array;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	/** This class keeps track of each element information. */
	private class Node {

		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * * returns the size of the linked list * @return
	 */

	public int size() {
		return size;
	}

	/**
	 * * return whether the list is empty or not * @return
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * * adds element at the starting of the linked list * @param element
	 * 
	 */
	public void addFirst(E element) {
		Node tmp = new Node(element, head, null);
		if (head != null) {
			head.prev = tmp;
		}
		head = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size++;
		// System.out.println("adding: " + element);
	}

	/**
	 * * adds element at the end of the linked list * @param element
	 */
	public void addLast(E element) {

		Node tmp = new Node(element, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size++;
		// System.out.println("adding: " + element);
	}

	/**
	 * * this method walks forward through the linked list
	 */
	public void iterateForward() {

		System.out.println("iterating forward..");
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}

	/**
	 * * this method walks backward through the linked list
	 */
	public void iterateBackward() {

		System.out.println("iterating backword..");
		Node tmp = tail;
		while (tmp != null) {
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}

	/**
	 * * this method removes element from the start of the linked list * @return
	 */
	public E removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: " + tmp.element);
		return tmp.element;
	}

	/**
	 * * this method removes element from the end of the linked list * @return
	 */
	public E removeLast() {
		if (size == 0)
			throw new NoSuchElementException();
		Node tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		// System.out.println("deleted: " + tmp.element);
		return tmp.element;
	}

	public void deleteNode(Object node) {
		if (head == null || node == null) {
			return;
		}
		Node del = (Node) node;
		boolean isDeleted = false;

		/* If node to be deleted is head node */
		if (head == del) {
			head = del.next;
		}

		/* Change next only if node to be deleted is NOT the last node */
		if (del.next != null) {
			del.next.prev = del.prev;
			isDeleted = true;
		}

		/* Change prev only if node to be deleted is NOT the first node */
		if (del.prev != null) {
			del.prev.next = del.next;
			isDeleted = true;
		}
		if (isDeleted) {
			size--;
		}
		/* Finally, free the memory occupied by del */
		return;
	}

	public E getElement(Object node) {
		if (head == null || node == null) {
			return null;
		}
		return ((Node) node).element;

	}

	/**
	 * Returns the last element of the list
	 */
	public Node getLast() {
		return tail;
	}

	/**
	 * Returns the first element of the list
	 */
	public Node getFirst() {
		return head;
	}

	public static void main(String a[]) {

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
	}
}