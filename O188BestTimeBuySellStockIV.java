public class O188BestTimeBuySellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		if (k >= prices.length) return maxProfit2(prices);
		int[][] local = new int[prices.length][k + 1];
		int[][] global = new int[prices.length][k + 1];
		local[0][0] = 0;
		global[0][0] = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		return global[prices.length - 1][k];
	}
	
	private int maxProfit2(int[] prices) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;
	}
}