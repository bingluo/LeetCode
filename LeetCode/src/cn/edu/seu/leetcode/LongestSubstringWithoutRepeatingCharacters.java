package cn.edu.seu.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	// version 1.0
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		int prevIndex[] = new int[s.length()];
		HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Integer pIndex = indexMap.get(s.charAt(i));
			if (pIndex == null) {
				prevIndex[i] = -1;
			} else {
				prevIndex[i] = pIndex;
			}
			indexMap.put(s.charAt(i), i);
		}
		int resultSIndex = 0, resultEIndex = 0;
		int startIndex = 0, endIndex = 0;
		for (int i = 0; i < prevIndex.length; i++) {
			if (prevIndex[i] >= startIndex) {
				startIndex = prevIndex[i] + 1;
			}
			endIndex = i;
			if (endIndex - startIndex > resultEIndex - resultSIndex) {
				resultSIndex = startIndex;
				resultEIndex = endIndex;
			}
		}
		return resultEIndex - resultSIndex + 1;
	}

	// version 2.0
	public int lengthOfLongestSubstringV2(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 1;
		int startIndex = 0;
		int endIndex = 0;
		map.put(s.charAt(0), 0);
		for (int i = 1; i < s.length(); i++) {
			Integer preIndex = map.get(s.charAt(i));
			map.put(s.charAt(i), i);
			if (preIndex != null && preIndex >= startIndex) {
				startIndex = preIndex + 1;
			}
			endIndex = i;
			maxLen = maxLen < endIndex - startIndex + 1 ? endIndex - startIndex
					+ 1 : maxLen;
		}
		return maxLen;
	}
}
