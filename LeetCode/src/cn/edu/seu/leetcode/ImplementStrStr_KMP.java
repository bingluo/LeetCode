package cn.edu.seu.leetcode;

public class ImplementStrStr_KMP {
	private int next[];

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		else if (haystack.length() == 0)
			return -1;

		getNext(needle.toCharArray());
		int i;
		int pIndex = -1;
		for (i = 0; i < haystack.length(); i++) {
			while (haystack.charAt(i) != needle.charAt(pIndex + 1)
					&& pIndex != -1) {
				pIndex = next[pIndex];
			}
			pIndex = haystack.charAt(i) == needle.charAt(pIndex + 1) ? pIndex + 1
					: -1;
			if (pIndex == needle.length() - 1)
				return i - pIndex;
		}

		return -1;
	}

	private void getNext(char p[]) {
		next = new int[p.length];
		next[0] = -1;
		int preIndex = -1;
		for (int i = 1; i < next.length; i++) {
			while (preIndex != -1 && p[i] != p[preIndex + 1])
				preIndex = next[preIndex];
			next[i] = p[i] == p[preIndex + 1] ? ++preIndex : -1;
		}
	}
}
