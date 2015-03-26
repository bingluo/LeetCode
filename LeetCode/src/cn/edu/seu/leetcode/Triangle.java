package cn.edu.seu.leetcode;

import java.util.List;

public class Triangle {
	// DP & recursion
	private int records[][];

	public int minimumTotal(List<List<Integer>> triangle) {
		records = new int[triangle.size()][];
		for (int i = 0; i < records.length; i++) {
			records[i] = new int[records.length];
			for (int j = 0; j < records.length; j++) {
				records[i][j] = Integer.MAX_VALUE;
			}
		}
		return minimumTotal(triangle, 0, 0);
	}

	private int minimumTotal(List<List<Integer>> triangle, int row, int col) {
		if (records[row][col] < Integer.MAX_VALUE)
			return records[row][col];

		int curVal = triangle.get(row).get(col);
		if (row == triangle.size() - 1)
			return curVal;

		int left = minimumTotal(triangle, row + 1, col);
		int right = minimumTotal(triangle, row + 1, col + 1);
		records[row][col] = left < right ? curVal + left : curVal + right;

		return records[row][col];
	}
}
