package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < num.length - 2; i++) {
			// avoid duplicates
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int left = i + 1;
				int right = num.length - 1;
				int sum = 0 - num[i];
				while (left < right) {
					if (num[left] + num[right] == sum) {
						list.add(Arrays.asList(num[i], num[left], num[right]));
						// avoid duplicates
						while (left < right && num[left] == num[left + 1])
							left++;
						while (left < right && num[right] == num[right - 1])
							right--;
						left++;
						right--;
					} else if (num[left] + num[right] < sum) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return list;
	}
}
