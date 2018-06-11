package com.algorithmforum.trie;

import java.util.HashMap;
import java.util.Map;


/**
 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * 
 * We build a Trie of all dictionary words. Once the Trie is built, traverse through it using characters of input string.
 * If prefix matches a dictionary word, store current length and look for a longer match. Finally, return the longest match.
 * 
 * @author rajesh.dixit
 * @since Jun 5, 2018 10:01:00 AM
 */
public class LongestPrefixMatching {

    // Trie Node, which stores a character and the children in a HashMap
    private static class TrieNode {


        private char value;
        private HashMap<Character, TrieNode> children;
        private boolean isEOW;

        public TrieNode(char ch) {
            value = ch;
            children = new HashMap<>();
            isEOW = false;
        }

    }


    private static final TrieNode root;
    static {
        root = new TrieNode((char) 0);
    }

    private static String getMatchingPrefix(String input) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        for (char ch : input.toCharArray()) {
            Map<Character, TrieNode> childMap = current.children;
            if (childMap.containsKey(ch)) {
                prefix.append(ch);
                current = childMap.get(ch);
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    private static void insert(String string) {
        TrieNode current = root;
        for (char ch : string.toCharArray()) {
            Map<Character, TrieNode> childMap = current.children;
            if (childMap.containsKey(ch)) {
                current = childMap.get(ch);
                continue;
            }
            TrieNode trieNode = new TrieNode(ch);
            childMap.put(ch, trieNode);
            current = trieNode;
        }
        current.isEOW = true;
    }

    public static void main(String[] args) {

        insert("are");
        insert("area");
        insert("base");
        insert("cat");
        insert("cater");
        insert("basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(input));
    }
}
