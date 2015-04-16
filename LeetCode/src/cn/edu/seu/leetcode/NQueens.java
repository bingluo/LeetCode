package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	private boolean chessboard[][];
	private List<String[]> ret = new ArrayList<String[]>();

	public List<String[]> solveNQueens(int n) {
		chessboard = new boolean[n][n];
		placeNextQueen(0);
		return ret;
	}

	private void placeNextQueen(int row) {
		if (row == chessboard.length) {
			String placement[] = new String[chessboard.length];
			for (int i = 0; i < chessboard.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (boolean flag : chessboard[i]) {
					sb.append(flag ? "Q" : ".");
				}
				placement[i] = sb.toString();
			}
			ret.add(placement);
		} else {
			for (int col = 0; col < chessboard.length; col++) {
				if (isLegal(row, col)) {
					chessboard[row][col] = true;
					placeNextQueen(row + 1);
					chessboard[row][col] = false;
				}
			}
		}
	}

	private boolean isLegal(int x, int y) {
		int i, j;
		for (i = x, j = y; 0 <= i && i < chessboard.length && 0 <= j
				&& j < chessboard.length; i--, j++) {
			if (chessboard[i][j])
				return false;
		}
		for (i = x, j = y; 0 <= i && i < chessboard.length && 0 <= j
				&& j < chessboard.length; i--, j--) {
			if (chessboard[i][j])
				return false;
		}
		for (i = 0; i < chessboard.length; i++) {
			if (chessboard[i][y])
				return false;
		}
		for (j = 0; i < chessboard.length; j++) {
			if (chessboard[x][j])
				return false;
		}

		return true;
	}
}
