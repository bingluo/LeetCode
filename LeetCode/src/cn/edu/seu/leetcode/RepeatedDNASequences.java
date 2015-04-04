package cn.edu.seu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		Object object = new Object();
		for (int i = 0; i < s.length() - 9; i++) {
			int key = hash(s, i);
			if (map.containsKey(key)) {
				map.put(key, object);
			} else {
				map.put(key, null);
			}
		}

		List<String> list = new ArrayList<String>();
		for (Entry<Integer, Object> entry : map.entrySet()) {
			if (entry.getValue() != null) {
				int key = entry.getKey();
				list.add(rebuild(key));
			}
		}
		return list;
	}

	private int hash(String s, int start) {
		int a = 0;
		for (int i = 0; i < 10; i++) {
			int temp = 0;
			switch (s.charAt(start + i)) {
			case 'A':
				temp = 0;
				break;
			case 'C':
				temp = 1;
				break;
			case 'G':
				temp = 2;
				break;
			case 'T':
				temp = 3;
				break;
			default:
				break;
			}
			a = a << 2;
			a += temp;
		}
		return a;
	}

	private String rebuild(int key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int temp = key % 4;
			switch (temp) {
			case 0:
				sb.append('A');
				break;
			case 1:
				sb.append('C');
				break;
			case 2:
				sb.append('G');
				break;
			case 3:
				sb.append('T');
				break;
			default:
				break;
			}
			key = key >> 2;
		}
		return sb.reverse().toString();
	}
}
