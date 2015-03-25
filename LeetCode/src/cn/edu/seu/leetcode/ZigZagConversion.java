package cn.edu.seu.leetcode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		StringBuilder sbs[] = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++)
			sbs[i] = new StringBuilder();

		for (int i = 0; i < nRows; i++) {
			int j = i;
			if (i == 0 || i == nRows - 1) {
				while (j < s.length()) {
					sbs[i].append(s.charAt(j));
					j += 2 * (nRows - 1);
				}
			} else {
				boolean flag = true;
				while (j < s.length()) {
					sbs[i].append(s.charAt(j));
					if (flag) {
						j += 2 * (nRows - i - 1);
						flag = false;
					} else {
						j += 2 * i;
						flag = true;
					}
				}
			}
		}
		for (int i = 1; i < nRows; i++) {
			sbs[0].append(sbs[i]);
		}
		return sbs[0].toString();
	}
}
