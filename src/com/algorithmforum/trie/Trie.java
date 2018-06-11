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


    private static boolean delete(String string) {
        TrieNode current = root;

        return false;
    }

    public static void main(String[] args) {
        // initialize Trie
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("pqr");
        trie.insert("abcd");

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

        // delete in Trie
        boolean isDeleted = delete("pqrs");

        System.out.println("Deleted, pqrs " + isFound);
    }
}
