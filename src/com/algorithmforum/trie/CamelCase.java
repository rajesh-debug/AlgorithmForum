package com.algorithmforum.trie;

//Java program to print all words in the CamelCase
//dictionary that matches with a given pattern
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
 * 
 * @author rajesh.dixit
 *
 */
public class CamelCase {

	// Alphabet size (# of upper-Case characters)
	static final int ALPHABET_SIZE = 26;

	// A Trie node
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// isLeaf is true if the node represents
		// end of a word
		boolean isLeaf;

		// vector to store list of complete words
		// in leaf node
		List<String> word;

		public TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;

			word = new ArrayList<String>();
		}
	}

	static TrieNode root;

	// Function to insert word into the Trie
	static void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (Character.isLowerCase(c)) {
				continue;
			}
			int index = c - 'A';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isLeaf = true;
		current.word.add(word);
	}

	// Function to print all children of Trie node 'node'
	static void printAllWords(TrieNode node) {

		// if current node is leaf
		if (node.isLeaf) {
			for (String str : node.word) {
				System.out.println(str);
			}
		}

		// recurse for all children of root node
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			TrieNode child = node.children[i];
			if (child != null) {
				printAllWords(child);
			}
		}
	}

	// search for pattern in Trie and print all words
	// matching that pattern
	static boolean search(String pattern) {
		TrieNode current = root;

		for (char c : pattern.toCharArray()) {
			int index = c - 'A';
			if (Character.isLowerCase(c) || current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}

		// print all words matching that pattern
		printAllWords(current);

		return true;
	}

	// Main function to print all words in the CamelCase
	// dictionary that matches with a given pattern
	static void findAllWords(List<String> dict, String pattern) {

		// construct Trie root node
		root = new TrieNode();

		// Construct Trie from given dict
		for (String word : dict)
			insert(word);

		// search for pattern in Trie
		if (!search(pattern))
			System.out.println("No match found");
	}

	// Driver function
	public static void main(String args[]) {

		// dictionary of words where each word follows
		// CamelCase notation
		List<String> dict = Arrays.asList("Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity",
				"HiTechLab");

		// pattern consisting of uppercase characters only
		String pattern = "H";

		findAllWords(dict, pattern);
	}
}
// This code is contributed by Sumit Ghosh
