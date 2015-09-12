package cn.edu.seu.leetcode;

public class BucketSort {
	/*	public int maximumGap(int[] num) {
	if (num.length < 2) {
		return 0;
	}
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < num.length; i++) {
		min = Math.min(num[i], min);
		max = Math.max(num[i], max);
	}
	int buckets[] = new int[max - min + 1];
	for (int i = 0; i < num.length; i++) {
		buckets[num[i] - min]++;
	}
	// confirm length/position
	for (int i = 1; i < buckets.length; i++) {
		buckets[i] = buckets[i] + buckets[i - 1];
	}
	int tmp[] = num;
	for (int i = 0; i < tmp.length; i++) {
		num[--buckets[tmp[i] - min]] = tmp[i];
	}
	int ret = 0;
	for (int i = 1; i < num.length; i++) {
		ret = Math.max(ret, Math.abs(num[i] - num[i - 1]));
	}
	return ret;
}*/
}
