package cn.edu.seu.leetcode;

public class SumRootToLeafNumbers {
	private int sum = 0;

	public int sumNumbers(TreeNode root) {
		calculate(root, 0);
		return sum;
	}

	private void calculate(TreeNode node, int value) {
		if (node == null)
			return;
		int curVal = value * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum += curVal;
		} else {
			calculate(node.left, curVal);
			calculate(node.right, curVal);
		}

	}
}
