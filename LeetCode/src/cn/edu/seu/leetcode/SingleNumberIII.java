package cn.edu.seu.leetcode;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			x ^= nums[i];
		}
		int y = 1;
		while ((x & y) != y) {
			y = y << 1;
		}
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((y & nums[i]) == y) {
				ret[0] ^= nums[i];
			} else {
				ret[1] ^= nums[i];
			}
		}
		return ret;
	}
}