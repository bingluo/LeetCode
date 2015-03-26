package cn.edu.seu.leetcode;

public class TrappingRainWater {
	public int trap(int[] A) {
		int left = 0, right = A.length - 1;
		int level = 0;
		int sum = 0;
		while (left < right) {
			level = level < Math.min(A[left], A[right]) ? Math.min(A[left],
					A[right]) : level;
			sum += A[left] < A[right] ? level - A[left++] : level - A[right--];
		}
		return sum;
	}
}
