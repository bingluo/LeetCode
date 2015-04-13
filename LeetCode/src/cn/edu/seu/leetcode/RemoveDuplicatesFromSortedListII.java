package cn.edu.seu.leetcode;

import cn.edu.seu.leetcode.AddTwoNumbers.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = null;
		ListNode p = null;
		ListNode cur = head;

		while (cur != null) {
			int val = cur.val;
			ListNode next = cur.next;
			if (next != null && next.val == val) {
				while (cur != null && cur.val == val) {
					cur = cur.next;
				}
			} else {
				if (newHead == null) {
					newHead = cur;
				}
				if (p == null) {
					p = cur;
				} else {
					p.next = cur;
					p = cur;
				}
				cur = cur.next;
				p.next = null;
			}
		}
		return newHead;
	}
}
