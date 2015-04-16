package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	boolean links[][];
	ArrayList<String> words;
	List<List<String>> ret = new ArrayList<List<String>>();

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		words = new ArrayList<String>(dict);
		links = new boolean[words.size()][words.size()];
		constructLinks(words);

		int startIndex = words.indexOf(start);
		int endIndex = words.indexOf(end);

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startIndex);
		ArrayList<Integer> from[] = new ArrayList[words.size()];
		for (int i = 0; i < words.size(); i++) {
			from[i] = new ArrayList<Integer>();
		}
		int stepsTo[] = new int[words.size()];
		stepsTo[startIndex] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			// not necessary to go deeper
			if (cur == endIndex)
				break;
			for (int i = 0; i < words.size(); i++) {
				if (links[cur][i]) {
					if (stepsTo[i] == 0) {
						queue.offer(i);
						stepsTo[i] = stepsTo[cur] + 1;
					}
					if (stepsTo[cur] + 1 <= stepsTo[i]) {
						from[i].add(cur);
					}
				}
			}
		}

		// trace back the route
		traceBack(from, endIndex, startIndex, new ArrayList<String>());

		return ret;
	}

	private void traceBack(ArrayList<Integer>[] from, int cur, int startIndex,
			ArrayList<String> list) {
		list.add(words.get(cur));
		if (cur == startIndex) {
			Collections.reverse(list);
			ret.add(list);
		} else {
			for (int i = 0; i < from[cur].size(); i++) {
				traceBack(from, from[cur].get(i), startIndex, i == 0 ? list
						: new ArrayList<String>(list));
			}
		}
	}

	private void constructLinks(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.size(); j++) {
				int diff = 0;
				String word1 = words.get(i);
				String word2 = words.get(j);
				for (int k = 0; k < word1.length(); k++) {
					diff = word1.charAt(k) == word2.charAt(k) ? diff : diff + 1;
				}
				links[i][j] = diff == 1;
			}
		}
	}
}
