package cn.edu.seu.leetcode;

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int one = 0, two = 0, three = 0;
		for (int i = 0; i < nums.length; i++) {
			three = two & nums[i];
			two = (one & nums[i]) | (two & ~nums[i]); // two or three
			one ^= nums[i];
			one &= ~three;
		}
		return one;
	}
}
