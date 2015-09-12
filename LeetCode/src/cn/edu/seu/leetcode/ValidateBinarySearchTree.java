package cn.edu.seu.leetcode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (null == root)
			return true;
		if (null != min && min >= root.val)
			return false;
		if (null != max && max <= root.val)
			return false;
		return isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);
	}
}
