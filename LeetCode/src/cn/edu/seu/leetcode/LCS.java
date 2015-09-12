package cn.edu.seu.leetcode;

import java.util.Arrays;

public class LCS {
	int dp[][];

	public int lcs(String word1, String word2) {
		dp = new int[word1.length()][word2.length()];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return lcs(word1.length() - 1, word2.length() - 1, word1, word2);
	}

	private int lcs(int x, int y, String word1, String word2) {
		if (dp[x][y] >= 0) {
			return dp[x][y];
		}
		if (x == 0 || y == 0) {
			dp[x][y] = word1.charAt(x) == word2.charAt(y) ? 1 : 0;
		} else {
			int v1 = lcs(x - 1, y - 1, word1, word2);
			if (word1.charAt(x) == word2.charAt(y)) {
				v1++;
			}
			int v2 = lcs(x - 1, y, word1, word2);
			int v3 = lcs(x, y - 1, word1, word2);
			dp[x][y] = Math.max(v1, Math.max(v2, v3));
		}
		return dp[x][y];
	}
}
