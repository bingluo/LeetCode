package cn.edu.seu.leetcode;

public class NQueensII {
	private int len;
	private boolean board[][];
	private int ret = 0;

	public int totalNQueens(int n) {
		len = n;
		board = new boolean[n][n];
		placeNext(0);
		return ret;
	}

	private void placeNext(int row) {
		if (row == len) {
			// print board
			ret++;
		} else {
			for (int col = 0; col < len; col++) {
				if (isSafe(row, col)) {
					board[row][col] = true;
					placeNext(row + 1);
					board[row][col] = false;
				}
			}
		}
	}

	private boolean isSafe(int row, int col) {
		int i, j;
		for (i = row, j = col; 0 <= i && i < len && 0 <= j && j < len; i--, j--) {
			if (board[i][j])
				return false;
		}
		for (i = row, j = col; 0 <= i && i < len && 0 <= j && j < len; i--, j++) {
			if (board[i][j])
				return false;
		}
		for (i = 0; i < len; i++) {
			if (board[i][col])
				return false;
		}
		for (j = 0; j < len; j++) {
			if (board[row][j])
				return false;
		}
		return true;
	}
}
