package cn.edu.seu.leetcode;

public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int i = 31;
		int m = 0;
		while (i >= 0) {
			m = m + ((n & 1) << i--);
			n >>= 1;
		}
		return m;
	}
}
