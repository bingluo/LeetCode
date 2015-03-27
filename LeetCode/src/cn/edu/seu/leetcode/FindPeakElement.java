package cn.edu.seu.leetcode;


public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num.length == 1)
			return 0;
		for (int i = 0; i < num.length; i++) {
			if (i == num.length - 1 || num[i] > num[i + 1])
				return i;
		}
		return -1;
	}
}
