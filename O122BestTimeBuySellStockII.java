public class O122BestTimeBuySellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int pre = prices[0];
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - pre > 0) {
				res += prices[i] - pre;
			}
			pre = prices[i];
		}
		return res;
	}
}