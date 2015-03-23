package cn.edu.seu.leetcode;

public class BestTimeToBuyAndSellStock {
	// dynamic programming: 最大子段和
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int profit[] = new int[prices.length];
		profit[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			profit[i] = prices[i] - prices[i - 1];
		}

		int maximumProfit[] = new int[profit.length];
		maximumProfit[0] = 0;
		int max = 0;
		for (int i = 1; i < profit.length; i++) {
			maximumProfit[i] = maximumProfit[i - 1] + profit[i] < 0 ? 0
					: maximumProfit[i - 1] + profit[i];
			max = max < maximumProfit[i] ? maximumProfit[i] : max;
		}
		return max;
	}
}
