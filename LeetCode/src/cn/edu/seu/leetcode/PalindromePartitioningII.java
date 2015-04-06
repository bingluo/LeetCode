package cn.edu.seu.leetcode;

public class PalindromePartitioningII {
	private boolean flag[][];

	public int minCut(String s) {
		int len = s.length();
		if (len <= 1)
			return 0;
		flag = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			setIsPalindrome(s, i, i);
			setIsPalindrome(s, i, i + 1);
		}

		int cutNum[] = new int[len];
		for (int i = 1; i < cutNum.length; i++) {
			int min = Integer.MAX_VALUE;
			int left = i;
			while (left >= 0) {
				if (flag[left][i]) {
					if (left == 0) {
						min = 0;
					} else {
						min = cutNum[left - 1] + 1 < min ? cutNum[left - 1] + 1
								: min;
					}
				}
				left--;
			}
			cutNum[i] = min;
		}
		return cutNum[len - 1];
	}

	private void setIsPalindrome(String s, int left, int right) {
		if (left < 0 || right >= s.length())
			return;
		if (s.charAt(left) == s.charAt(right)) {
			flag[left][right] = true;
			setIsPalindrome(s, left - 1, right + 1);
		}
	}
}
