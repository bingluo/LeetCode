package cn.edu.seu.leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			String tempS = longestPalindromeFromMe(i, i, s);
			String tempD = (i < s.length() - 1)
					&& (s.charAt(i) == s.charAt(i + 1)) ? longestPalindromeFromMe(
					i, i + 1, s) : "";
			if (tempS.length() > longest.length())
				longest = tempS;
			if (tempD.length() > longest.length())
				longest = tempD;
		}
		return longest;
	}

	private String longestPalindromeFromMe(int leftIndex, int rightIndex,
			String s) {
		if (leftIndex == 0 || rightIndex == s.length() - 1
				|| s.charAt(leftIndex - 1) != s.charAt(rightIndex + 1))
			return s.substring(leftIndex, rightIndex + 1);
		else
			return longestPalindromeFromMe(leftIndex - 1, rightIndex + 1, s);
	}
}
