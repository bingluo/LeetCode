package cn.edu.seu.leetcode;

import java.util.Arrays;

public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			min = Math.min(num[i], min);
			max = Math.max(num[i], max);
		}
		int tmp = max - min;
		int distance = 0;
		while (tmp > 0) {
			distance++;
			tmp /= 10;
		}

		int tempArray[] = null;
		int buckets[] = new int[10];
		int divide = 1;
		for (int i = 0; i < distance; i++) {
			tempArray = Arrays.copyOf(num, num.length);
			Arrays.fill(buckets, 0);
			for (int j = 0; j < num.length; j++) {
				int bKey = ((tempArray[j] - min) / divide) % 10;
				buckets[bKey]++;
			}
			int bucketsTmp[] = Arrays.copyOf(buckets, buckets.length);
			for (int j = 1; j < buckets.length; j++) {
				buckets[j] = buckets[j] + buckets[j - 1];
			}
			for (int j = 0; j < num.length; j++) {
				int index = buckets[((tempArray[j] - min) / divide) % 10];
				int count = bucketsTmp[((tempArray[j] - min) / divide) % 10]--;
				num[index - count] = tempArray[j];
			}
			divide *= 10;
		}

		int ret = 0;
		for (int i = 1; i < num.length; i++) {
			ret = Math.max(ret, Math.abs(num[i] - num[i - 1]));
		}

		return ret;
	}
}
