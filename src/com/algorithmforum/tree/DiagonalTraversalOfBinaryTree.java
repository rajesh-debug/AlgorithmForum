package com.algorithmforum.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


/**
 * Diagonal Traversal of Binary Tree
 * 
 * Print all diagonal elements in a binary tree belonging to same line
 * 
 * https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
 * 
 * @author rajesh.dixit
 * @since May 29, 2018 5:20:50 PM
 */
public class DiagonalTraversalOfBinaryTree {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    private static void diagonalPrintUtil(Node root, int d, HashMap<Integer, List<Integer>> map) {
        
        if(root == null) {
            return;
        }
        
        List<Integer> diagonal = map.get(d);
        if (diagonal == null) {
            diagonal = new ArrayList<>();
        }
        diagonal.add(root.data);
        map.put(d, diagonal);

        diagonalPrintUtil(root.left, d + 1, map);
        diagonalPrintUtil(root.right, d, map);
    }

    // Print diagonal traversal of given binary tree
    private static void diagonalPrint(Node root) {
        // create a map of vectors to store Diagonal elements
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        diagonalPrintUtil(root, 0, map);

        System.out.println("Diagonal Traversal of Binnary Tree");
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Driver program
    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalPrint(root);
    }
}
