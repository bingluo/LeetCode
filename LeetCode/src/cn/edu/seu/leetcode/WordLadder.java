package cn.edu.seu.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/**
	 * O(N*len)
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordDict
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordDict) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		wordDict.add(endWord);
		int step = 0;
		while (!queue.isEmpty()) {
			Queue<String> level = new LinkedList<String>();
			step++;
			while (!queue.isEmpty()) {
				String cur = queue.poll();
				if (cur.equals(endWord))
					return step;
				for (int i = 0; i < cur.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						String newString = cur.substring(0, i) + c
								+ cur.substring(i + 1, cur.length());
						if (!newString.equals(cur)
								&& wordDict.contains(newString)) {
							level.offer(newString);
							wordDict.remove(newString);
						}
					}
				}
			}
			queue = level;
		}

		return 0;
	}

	/**
	 * O(N^2) solution
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordDict
	 * @return
	 */
	public int ladderLength1(String beginWord, String endWord,
			Set<String> wordDict) {
		String[] dicts = new String[wordDict.size()];
		HashMap<String, Integer> stepMap = new HashMap<String, Integer>();
		HashMap<String, Integer> stringIndexMap = new HashMap<String, Integer>();
		Iterator<String> iterator = wordDict.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			String tmp = iterator.next();
			stringIndexMap.put(tmp, i);
			dicts[i] = tmp;
		}

		boolean links[][] = new boolean[dicts.length][dicts.length];
		for (int i = 0; i < dicts.length; i++) {
			for (int j = 0; j < links.length; j++) {
				if (i != j && isNext(dicts[i], dicts[j])) {
					links[i][j] = true;
				}
			}
		}

		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		stepMap.put(beginWord, 1);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			int curIndex = stringIndexMap.get(cur);
			for (int i = 0; i < dicts.length; i++) {
				if (links[i][curIndex] && stepMap.get(dicts[i]) == null) {
					stepMap.put(dicts[i], stepMap.get(cur) + 1);
					queue.offer(dicts[i]);
					if (dicts[i].equals(endWord)) {
						return stepMap.get(endWord);
					}
				}
			}
		}

		return stepMap.get(endWord) == null ? 0 : stepMap.get(endWord);
	}

	private boolean isNext(String a, String b) {
		int diff = 0;
		int i = 0, j = 0;
		while (i < a.length() && j < a.length()) {
			diff = a.charAt(i) == b.charAt(j) ? diff : diff + 1;
			i++;
			j++;
			if (diff > 1) {
				return false;
			}
		}
		diff += a.length() - i;
		diff += b.length() - j;
		return diff == 1;
	}
}
