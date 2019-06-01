package com.leetcode.caching;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

	private final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Remove the key and add it again to map to make it most recent used.
	 * 
	 * @param key
	 * @return value
	 */
	public int get(int key) {
		Integer removed = remove(key);
		if (removed == null) {
			removed = -1;
		} else {
			super.put(key, removed);
		}
		return removed;
	}

	/**
	 * Remove if key already exists. Add the key on the top.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		super.remove(key);
		super.put(key, value);
	}

	/**
	 * If capacity is reached, remove the least used eleemnt from the map.
	 * 
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4

	}
}