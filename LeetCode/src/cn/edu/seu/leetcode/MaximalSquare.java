package cn.edu.seu.leetcode;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sizeMatrix = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					sizeMatrix[i][j] = Math.min(Math.min(
							sizeMatrix[i - 1][j - 1], sizeMatrix[i - 1][j]),
							sizeMatrix[i][j - 1]) + 1;
					result = Math.max(result, sizeMatrix[i][j]);
				}
			}
		}
		return result * result;
	}
}
