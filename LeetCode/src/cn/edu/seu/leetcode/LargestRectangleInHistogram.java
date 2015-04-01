package cn.edu.seu.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	// O(N)
	public int largestRectangleArea(int[] height) {
		int max = 0;

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
				int cur = stack.pop();
				int temp = !stack.isEmpty() ? height[cur]
						* (i - stack.peek() - 1) : height[cur] * (i - 0);
				max = temp > max ? temp : max;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			int temp = !stack.isEmpty() ? height[cur]
					* (height.length - stack.peek() - 1) : height[cur]
					* (height.length - 0);
			max = temp > max ? temp : max;
		}
		return max;
	}

	// O(N^2)
	public int largestRectangleAreaN2(int[] height) {
		int area[] = new int[height.length];
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				if (height[j] >= height[i])
					area[i] += height[j];
				else
					break;
			}
			max = max < area[i] ? area[i] : max;
		}
		return max;
	}
}
