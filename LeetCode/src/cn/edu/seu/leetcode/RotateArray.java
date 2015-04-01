package cn.edu.seu.leetcode;

public class RotateArray {
	// normal solution
	public class Solution {
		public void rotate(int[] nums, int k) {
			k = k % nums.length;
			int[] temp = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				if (i >= nums.length - k)
					temp[i - nums.length + k] = nums[i];
				else
					temp[i + k] = nums[i];
			}
			for (int i = 0; i < nums.length; i++)
				nums[i] = temp[i];
		}
	}

	// O(1) solution
	public static class SolutionO1 {
		public static void rotate(int[] nums, int k) {
			if (nums.length < 2)
				return;
			int len = nums.length;
			int initial = 0;
			int index = 0;
			int value = nums[0];
			for (int i = 0; i < len; i++) {
				int toIndex = (index + k) % len;
				int temp = nums[toIndex];
				nums[toIndex] = value;
				value = temp;
				index = toIndex;
				if (index == initial) {
					index = ++initial % len;
					value = nums[index];
				}
			}
		}
	}

}
