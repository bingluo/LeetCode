package cn.edu.seu.leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int ret[] = null;
		for (int i : digits) {
			if (i != 9) {
				ret = new int[digits.length];
				break;
			}
		}
		if (ret == null) {
			ret = new int[digits.length + 1];
			ret[0] = 1;
			return ret;
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + carry == 10) {
				ret[i] = 0;
			} else {
				ret[i] = digits[i] + carry;
				carry = 0;
			}
		}
		return ret;
	}
}
