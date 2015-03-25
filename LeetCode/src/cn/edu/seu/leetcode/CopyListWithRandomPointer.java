package cn.edu.seu.leetcode;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	private HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode newHead = deepCopy(head);
		RandomListNode currentNode = newHead;
		while (head != null) {
			if (head.random != null)
				currentNode.random = map.get(head.random.label);
			head = head.next;
			currentNode = currentNode.next;
		}
		return newHead;
	}

	private RandomListNode deepCopy(RandomListNode node) {
		if (node == null)
			return null;
		RandomListNode newNode = new RandomListNode(node.label);
		newNode.next = deepCopy(node.next);
		map.put(newNode.label, newNode);
		return newNode;
	}
}
