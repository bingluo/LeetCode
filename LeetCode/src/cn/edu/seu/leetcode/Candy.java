package cn.edu.seu.leetcode;

public class Candy {
	public int candy(int[] ratings) {
		int len = ratings.length;
		if (len == 0)
			return 0;

		int asc[] = new int[len];
		int desc[] = new int[len];
		asc[0] = 1;
		desc[len - 1] = 1;
		for (int i = 1; i < len; i++) {
			int right = len - 1 - i;
			asc[i] = ratings[i] > ratings[i - 1] ? asc[i - 1] + 1 : 1;
			desc[right] = ratings[right] > ratings[right + 1] ? desc[right + 1] + 1
					: 1;
		}
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += Math.max(asc[i], desc[i]);
		}
		return sum;
	}
}
