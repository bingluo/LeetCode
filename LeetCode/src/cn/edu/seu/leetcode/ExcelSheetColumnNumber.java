package cn.edu.seu.leetcode;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int result = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			result += (s.charAt(len - i - 1) - 'A' + 1) * Math.pow(26, i);
		}
		return result;
	}
}
