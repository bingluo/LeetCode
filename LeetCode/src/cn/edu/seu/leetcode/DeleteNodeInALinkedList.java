package cn.edu.seu.leetcode;

public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
