package cn.edu.seu.leetcode;

import java.util.HashMap;

//
public class LongestSubstringWithoutRepeatingCharacters {
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
}
