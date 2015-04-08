package cn.edu.seu.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int a = x < 0 ? -1 : 1;
		int absVal = Math.abs(x);
		long ret = 0;
		while (absVal > 0) {
			ret = 10 * ret + absVal % 10;
			absVal /= 10;
			if (ret > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int) (a * ret);
	}
}
