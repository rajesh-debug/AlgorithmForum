package com.algorithmforum.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * Java Program to find diagonal sum in a Binary Tree
 * 
 * @author rajesh.dixit
 * @since Sep 5, 2018 8:38:43 PM
 */

//Tree node
class TreeNode {

    int data;
    TreeNode left, right; 
    
    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}

//Tree class
class Tree {

    // Diagonal sum method
    public static void diagonalSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sumMap.put(++level, sum);
                sum = 0;
                queue.add(null);
                if (!queue.isEmpty()) {
                    node = queue.poll();
                }

            }

            while (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                sum = sum + node.data;
                node = node.right;
            }
        }

        System.out.println(sumMap);
    }
}

//Driver class
public class DiagonalSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        Tree.diagonalSum(root);
    }
}