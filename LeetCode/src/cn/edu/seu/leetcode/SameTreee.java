package cn.edu.seu.leetcode;

public class SameTreee {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (null == p || null == q)
			return p == q;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
