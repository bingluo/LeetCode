package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
	private Stack<Integer> stack = new Stack<Integer>();
	private List<List<Integer>> list = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k) {
		findCombination(n, k, 1);
		return list;
	}

	private void findCombination(int n, int k, int min) {
		if (stack.size() == k) {
			List<Integer> newList = new ArrayList<>();
			Object[] array = stack.toArray();
			for (Object obj : array) {
				newList.add((Integer) obj);
			}
			list.add(newList);
		} else if (k - stack.size() <= n - min + 1) {
			for (int i = min; i <= n; i++) {
				stack.push(i);
				findCombination(n, k, i + 1);
				stack.pop();
			}
		}
	}
}
