package cn.edu.seu.leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int maxSum = A[0];
		int sum = A[0];
		for (int i = 1; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}
}
