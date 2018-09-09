package com.algorithmforum.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
 * 
 * @author rajesh.dixit
 */
public class PairSumEqualsToRoot {

	private static boolean isPairSumEqualsToRoot(TreeNode node) {
		Set<Integer> set = new HashSet<>();
		int rootVal = node.data;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			if(node.left !=null) {
				if(set.contains(rootVal - node.left.data)) {
					return true;
				} else {
					set.add(node.left.data);
					queue.add(node.left);
				}
			}
			
			if(node.right !=null) {
				if(set.contains(rootVal - node.right.data)) {
					return true;
				} else {
					set.add(node.right.data);
					queue.add(node.right);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(21);
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
		System.out.println(isPairSumEqualsToRoot(root));
	}

}
