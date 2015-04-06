package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		list.add(new ArrayList<Integer>());
		int size = 0;
		for (int i = 0; i < num.length; i++) {
			int startIndex = i > 0 && num[i] == num[i - 1] ? size : 0;
			size = list.size();
			for (int j = startIndex; j < size; j++) {
				ArrayList<Integer> newList = new ArrayList<Integer>(list.get(j));
				newList.add(num[i]);
				list.add(newList);
			}
		}
		return list;
	}
}
