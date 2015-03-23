package cn.edu.seu.leetcode;

public class NumberOf1Bits {
	public static int reverseBits(int n) {
		int i = 31;
		int m = 0;
		while (i >= 0) {
			m = m + ((n & 1) << i--);
			n >>= 1;
		}
		return m;
	}
}
