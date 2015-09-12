package cn.edu.seu.leetcode;

public class AddTwoNumbers {

	private int carry = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			if (l1 == null && l2 == null) {
				if (carry == 0)
					return null;
				else
					return new ListNode(carry);
			} else if (l1 == null) {
				int val = carry + l2.val;
				carry = val / 10;
				ListNode node = new ListNode(val % 10);
				node.next = addTwoNumbers(null, l2.next);
				return node;
			} else {
				int val = carry + l1.val;
				carry = val / 10;
				ListNode node = new ListNode(val % 10);
				node.next = addTwoNumbers(l1.next, null);
				return node;
			}
		} else {
			int val = l1.val + l2.val + carry;
			carry = val / 10;
			ListNode node = new ListNode(val % 10);
			node.next = addTwoNumbers(l1.next, l2.next);
			return node;
		}
	}
}
