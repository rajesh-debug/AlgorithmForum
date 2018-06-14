package com.algorithmforum.osutil;

import java.util.HashMap;
import java.util.Map;

import com.algorithmforum.array.DoublyLinkedList;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * 
 * @author rajesh.dixit
 */
public class LRUCache {

	private class Node {
		int element;

		public Node(int element) {
			this.element = element;
		}
	}

	private int MAX_SIZE = 10;
	private DoublyLinkedList<Node> doublyLinkList;
	private Map<Integer, Object> map;

	public LRUCache(int maxSize) {
		this.MAX_SIZE = maxSize;
		this.doublyLinkList = new DoublyLinkedList<Node>();
		this.map = new HashMap<>();
	}

	public boolean addElement(int value) {
		if (doublyLinkList.size() == MAX_SIZE) {
			Node tNode = doublyLinkList.removeLast();
			map.remove(tNode.element);
			System.out.printf("Cache is full, %d has been removed \n", tNode.element);
		}
		Node node = new Node(value);
		doublyLinkList.addFirst(node);
		map.put(value, doublyLinkList.getFirst());
		System.out.printf("%d has been added \n", node.element);
		return true;
	}

	public boolean getElement(int value) {

		if (!map.containsKey(value)) {
			System.out.println("Element does exist in the Cache ");
			return false;
		}

		if (map.get(value) != null) {
			Node node = doublyLinkList.getElement(map.get(value));
			if (node == null) {
				System.err.printf("No element found in the Cache");
			} else {
				System.out.printf("Fetch element %d from Cache\n", node.element);
			}
		}
		return true;

	}

	public boolean deleteElement(int value) {
		if (!map.containsKey(value)) {
			System.out.println("Element does exist in the Cache ");
			return false;
		}

		if (map.get(value) != null) {
			doublyLinkList.deleteNode(map.get(value));
			map.remove(value);
			System.out.printf(" %d has been deleted \n", value);
		}
		return true;
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(3);
		lruCache.addElement(1);
		lruCache.addElement(2);
		lruCache.addElement(3);
		lruCache.addElement(6);
		lruCache.addElement(4);
		lruCache.addElement(5);
		lruCache.deleteElement(5);
		lruCache.getElement(6);
		lruCache.getElement(5);
	}
}