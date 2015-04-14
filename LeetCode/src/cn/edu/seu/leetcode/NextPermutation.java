package cn.edu.seu.leetcode;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int len = num.length;
		int index = len - 2;
		while (index >= 0 && num[index] >= num[index + 1]) {
			index--;
		}
		if (index >= 0) {
			int swapIndex = index + 1;
			for (int i = index + 2; i < len; i++) {
				swapIndex = num[index] < num[i] && num[swapIndex] > num[i] ? i
						: swapIndex;
			}
			int temp = num[index];
			num[index] = num[swapIndex];
			num[swapIndex] = temp;
		}
		Arrays.sort(num, index + 1, len);
	}
}
