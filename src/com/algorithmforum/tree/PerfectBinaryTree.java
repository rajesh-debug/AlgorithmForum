package com.algorithmforum.tree;

/**
 * Function to check whether the given Binary Tree is a perfect Binary Tree or not.
 *  
 * <B>Perfect Binary Tree</B> All internal nodes have two children and all leaves are at same level.
 * 
 * https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
 * 
 * A Perfect Binary Tree of height h has 2^h � 1 nodes.
 * 
 * Approach#1
 *  Find depth 'd' of any node
 *      Now recursively traverse the tree and check for below two conditions.
 *      1. Every internal node should have both children non-empty
 *      2. All leaves are at depth 'd'.
 * 
 * Approach#2
 *  Count the number of nodes and it should be equals to 2^h-1 for h height tree.
 *  
 * @author rajesh.dixit
 * @since May 30, 2018 12:56:51 PM
 */
public class PerfectBinaryTree {

    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    
   private static int getHeight(Node node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
   
    private static boolean isPBTUtil(Node node, int depth, int height) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return height == depth + 1;
        } else if (node.left == null || node.right == null) {
            return height == depth + 1;
        }

        return isPBTUtil(node.left, depth + 1, height) && isPBTUtil(node.right, depth + 1, height);
    }

    private static boolean isPerfectBinaryTree(Node root) {
        int height = getHeight(root);
        boolean result = isPBTUtil(root, 0, height);
        return result;
    }
    
    /** Counting Approach - Start. */
    private static int isPBTUtilCountApproach(Node node) {
        if (node == null) {
            return 0;
        }
        return isPBTUtilCountApproach(node.left) + isPBTUtilCountApproach(node.right) + 1;
    }
    
    private static boolean isPBTCountApproach(Node root) {
        int height = getHeight(root);
        int count = isPBTUtilCountApproach(root);
        return count == (int) Math.pow(2, height) - 1;
    }
    /** Counting Approach - End. */
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        boolean isPBTree = isPerfectBinaryTree(root);

        System.out.println("Tree is perfect binary tree " + isPBTree);
        
        isPBTree = isPBTCountApproach(root);

        System.out.println("Tree is perfect binary tree " + isPBTree);
    }
}