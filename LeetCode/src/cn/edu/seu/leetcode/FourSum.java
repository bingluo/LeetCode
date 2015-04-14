package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int toSum = target - num[i] - num[j];
				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					if (num[left] + num[right] == toSum) {
						int l = num[left];
						int r = num[right];
						list.add(Arrays.asList(num[i], num[j], l, r));
						while (left < right && num[left] == l)
							left++;
						while (left < right && num[right] == r)
							right--;
					} else if (num[left] + num[right] < toSum) {
						left++;
					} else {
						right--;
					}
				}
				while (j + 1 < num.length && num[j + 1] == num[j])
					j++;
			}
			while (i + 1 < num.length && num[i + 1] == num[i])
				i++;
		}
		return list;
	}
}
