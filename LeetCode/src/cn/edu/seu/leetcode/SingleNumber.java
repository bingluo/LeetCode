package cn.edu.seu.leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int r = 0;
		for (int a : A) {
			r ^= a;
		}
		return r;
	}
}
