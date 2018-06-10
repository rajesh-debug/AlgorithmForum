package com.algorithmforum.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * 
 * @author rajesh.dixit
 *
 */
public class LongestPrefixMatching {

	private static class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		@Override
		public String toString() {
			return "[" + children + "," + endOfWord + "]";
		}
	}

	private static TrieNode root;

	public LongestPrefixMatching() {
		root = new TrieNode();
	}

	private void insert(String[] words) {
		for (String word : words) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				TrieNode node = current.children.get(ch);
				if (node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				current = node;
			}
			// mark the current nodes endOfWord as true
			current.endOfWord = true;
		}
	}

	private static String longestPrefix(String word) {
		int idx = 0;
		boolean found = false;
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (current == null || current.children == null) {
				break;
			}
			current = current.children.get(ch);
			if (current != null && current.endOfWord) {
				found = true;
				idx = i;
			}
		}
		if (found && idx <= word.length()) {
			return word.substring(0, idx + 1);
		}
		return null;
	}

	public static void main(String[] args) {
		// initialize Trie
		LongestPrefixMatching trie = new LongestPrefixMatching();
		String[] prefixs = { "are", "area", "base", "cat", "cater", "children", "basement" };
		trie.insert(prefixs);

		// search in Trie
		String longestPrefix = longestPrefix("catermentss");

		System.out.println("Prefix, catermentss " + longestPrefix);
		
		// search in Trie
		longestPrefix = longestPrefix("banana");

		System.out.println("Prefix, banana " + longestPrefix);
		
		// search in Trie
		longestPrefix = longestPrefix("basemexy");

		System.out.println("Prefix, basemexy " + longestPrefix);
		
	}

}
