package cn.edu.seu.leetcode;

import cn.edu.seu.leetcode.AddTwoNumbers.ListNode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		int len = 0;
		ListNode curP = null;
		ListNode cur = head;
		while (cur != null) {
			len++;
			curP = cur;
			cur = cur.next;
		}
		k = k % len;
		if (k == 0)
			return head;
		curP.next = head;

		cur = head;
		for (int i = 1; i < len - k; i++) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		return head;
	}
}
