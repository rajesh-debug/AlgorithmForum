package com.algorithmforum.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/implement-a-phone-directory/
 * 
 * @author rajesh.dixit
 *
 */
public class PhoneDirectory {

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

	public PhoneDirectory() {
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

	private static void searchPhoneUtil(String word) {
		int idx = 0;
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (current == null || current.children == null) {
				break;
			}
			current = current.children.get(ch);
		}
		if (current != null) {
			printPhoneNumbers(current, word);
		} else {
			System.out.println("No match is found");
		}
	}

	private static void printPhoneNumbers(TrieNode current, String prefix) {

		if (current == null || current.children == null || current.endOfWord) {
			System.out.println(prefix);
		}

		Map<Character, TrieNode> map = current.children;
		for (Character ch : map.keySet()) {
			printPhoneNumbers(current.children.get(ch), prefix + ch);
		}

	}

	public static void main(String[] args) {
		// initialize Trie
		PhoneDirectory trie = new PhoneDirectory();
		String[] contacts = { "gforgeeks", "geeksquiz", "geeksforgeeks" };
		trie.insert(contacts);

		// Search phone number
		searchPhoneUtil("geek");

	}

}
