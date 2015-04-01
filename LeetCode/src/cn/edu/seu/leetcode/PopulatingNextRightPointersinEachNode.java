package cn.edu.seu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// O(n) space solution: using queue
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			if (node != null) {
				node.next = queue.peek();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			} else {
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
	}

	// O(1) space solution
	public void connectConstantSpace(TreeLinkNode root) {
		TreeLinkNode levelHead = root;
		TreeLinkNode cur = levelHead;
		while (levelHead != null) {
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			levelHead = levelHead.left;
			cur = levelHead;
		}
	}
}
