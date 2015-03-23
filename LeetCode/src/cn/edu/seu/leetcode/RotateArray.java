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
			int length = nums.length;
			k = k % length;
			int initial = 0;
			int tempA = nums[0];
			int tempB;
			int index = 0;
			int toIndex;
			for (int i = 0; i < length; i++) {
				toIndex = (index + k) % length;
				tempB = nums[toIndex];
				nums[toIndex] = tempA;
				tempA = tempB;
				index = toIndex;
				if (index == initial) {
					index = ++initial;
					tempA = nums[index];
				}
			}
		}
	}

}
