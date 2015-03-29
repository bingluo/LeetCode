package cn.edu.seu.leetcode;

public class DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();
		char array[] = s.toCharArray();
		if (len == 0 || array[0] == '0')
			return 0;
		int ways[] = new int[len + 1];
		ways[0] = 1;
		ways[1] = 1;

		for (int i = 1; i < len; i++) {
			// 00 or 30...90
			if (array[i] == '0' && array[i - 1] != '1' && array[i - 1] != '2')
				return 0;
			// x1...x9
			if (array[i] != '0')
				ways[i + 1] += ways[i];
			// 10...26
			if (10 <= Integer.valueOf(s.substring(i - 1, i + 1))
					&& Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
				ways[i + 1] += ways[i - 1];
		}
		return ways[len];
	}
}
