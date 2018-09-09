package com.algorithmforum.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

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

	public Trie() {
		root = new TrieNode();
	}

	private void insert(String word) {
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

	private static boolean searchWholeWord(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		// mark the current nodes endOfWord as true
		return current.endOfWord;
	}

	private static boolean searchPrefix(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		// mark the current nodes endOfWord as true
		return true;
	}

	/**
	 * Delete word from trie.
	 * 
	 * @return
	 */
	public static boolean delete(String word) {
		return delete(root, word, 0);
	}

	private static boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			// when end of word is reached only delete if currrent.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			// if current has no other mapping then return true
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		// if true is returned then delete the mapping of character and trienode
		// reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			// return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		// initialize Trie
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("pqr");
		trie.insert("abcd");
		trie.insert("pq");

		// search in Trie
		boolean isFound = searchWholeWord("pqr");
		System.out.println("Search whole word, pqr " + isFound);

		// search in Trie
		isFound = searchWholeWord("pq");
		System.out.println("Search whole word, pq " + isFound);

		// search in Trie
		isFound = searchPrefix("ab");

		System.out.println("Search prefix, ab " + isFound);

		// search in Trie
		isFound = searchPrefix("pqrs");

		System.out.println("Search prefix, pqrs " + isFound);

		// search in Trie
		isFound = searchWholeWord("pq");
		System.out.println("Search whole word, pq " + isFound);

		// delete in Trie
		boolean isDeleted = delete("pq");

		System.out.println("Deleted, pq " + isDeleted);

		// search in Trie
		isFound = searchWholeWord("pq");
		System.out.println("Search whole word, pq " + isFound);
	}
}
