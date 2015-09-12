package cn.edu.seu.leetcode;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (null == nums || nums.length == 0 || k <= 0) {
			return false;
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			Integer top = set.ceiling(nums[i]);
			Integer bottom = set.floor(nums[i]);
			if (top!=null && top <= nums[i] + t || bottom!=null && bottom >= nums[i] - t) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
