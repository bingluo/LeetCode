package cn.edu.seu.leetcode;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit = prices[i] > prices[i - 1] ? profit + prices[i]
					- prices[i - 1] : profit;
		}
		return profit;
	}
}
