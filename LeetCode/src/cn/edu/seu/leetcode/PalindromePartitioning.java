package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	private boolean isPalin[][];
	private List<List<String>> result = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		int len = s.length();
		isPalin = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			// start from i
			int left = i;
			int right = i;
			while (0 <= left && right < len
					&& s.charAt(left) == s.charAt(right)) {
				isPalin[left--][right++] = true;
			}
			// start from i, i+1
			left = i;
			right = i + 1;
			while (0 <= left && right < len
					&& s.charAt(left) == s.charAt(right)) {
				isPalin[left--][right++] = true;
			}
		}
		partition(s, 0, new ArrayList<String>());
		return result;
	}

	private void partition(String s, int startIndex, List<String> list) {
		if (startIndex == s.length()) {
			result.add(list);
			return;
		}
		for (int i = startIndex; i < s.length(); i++) {
			if (isPalin[startIndex][i]) {
				list.add(s.substring(startIndex, i + 1));
				List<String> newList = new ArrayList<String>(list);
				partition(s, i + 1, newList);
				list.remove(list.size() - 1);
			}
		}
	}
}
