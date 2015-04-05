package cn.edu.seu.leetcode;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
		return findMin(num, 0, num.length - 1);
	}

	private int findMin(int[] num, int left, int right) {
		if (left == right) {
			return num[left];
		}
		int mid = num[(left + right) / 2];
		return mid < num[right] ? findMin(num, left, (left + right) / 2)
				: findMin(num, (left + right) / 2 + 1, right);
	}
}
