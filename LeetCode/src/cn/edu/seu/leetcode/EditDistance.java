package cn.edu.seu.leetcode;

import java.util.Arrays;

public class EditDistance {
	private int dp[][];

	public int minDistance(String word1, String word2) {
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.max(word1.length(), word2.length());
		}
		dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < word1.length() + 1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < word2.length() + 1; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
				dp[i][j] = Math.min(dp[i - 1][j - 1] + cost,
						Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
			}
		}
		return dp[word1.length()][word2.length()];
	}

	public int minDistance1(String word1, String word2) {
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.max(word1.length(), word2.length());
		}
		dp = new int[word1.length()][word2.length()];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return editDistance(word1.length() - 1, word2.length() - 1, word1,
				word2);
	}

	private int editDistance(int x, int y, String word1, String word2) {
		if (dp[x][y] >= 0) {
			return dp[x][y];
		}
		if (x == 0 || y == 0) {
			dp[x][y] = word1.charAt(x) == word2.charAt(y) ? Math.max(x, y)
					: Math.max(x, y) + 1;
		} else {
			int cost = word1.charAt(x) == word2.charAt(y) ? 0 : 1;
			int v1 = editDistance(x - 1, y - 1, word1, word2) + cost;
			int v2 = editDistance(x - 1, y, word1, word2) + 1;
			int v3 = editDistance(x, y - 1, word1, word2) + 1;
			dp[x][y] = Math.min(v1, Math.min(v2, v3));
		}
		return dp[x][y];
	}
}
