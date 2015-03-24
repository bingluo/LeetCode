package cn.edu.seu.leetcode;

import java.util.LinkedHashMap;

//Trick method: using LinkedHashMap
public class LRUCache {
	private LinkedHashMap<Integer, Integer> cacheMap;
	private final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new LinkedHashMap<>();
	}

	public int get(int key) {
		Integer value = cacheMap.remove(key);
		if (value == null) {
			return -1;
		}
		cacheMap.put(key, value);
		return value;
	}

	public void set(int key, int value) {
		if (cacheMap.containsKey(key)) {
			cacheMap.remove(key);
		} else if (cacheMap.size() == capacity) {
			cacheMap.remove(cacheMap.keySet().iterator().next());
		}
		cacheMap.put(key, value);
	}
}
