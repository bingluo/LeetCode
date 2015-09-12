package cn.edu.seu.leetcode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (null == root)
			return root;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
