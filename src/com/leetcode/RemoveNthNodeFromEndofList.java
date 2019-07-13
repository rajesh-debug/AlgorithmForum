package com.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		ListNode n1 = head;
		ListNode n2 = head;

		while (n >= 0 && n1 != null) {
			n1 = n1.next;
			n--;
		}

		while (n2 != null) {
			if (n1 == null && n2 != null) {
				// System.out.println(n2.val);
				if (n2.next != null) {
					n2.next = n2.next.next;
				} else {

				}
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}

		return head;

	}
}