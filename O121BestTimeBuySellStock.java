public class  O121BestTimeBuySellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int lowest = prices[0];
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < lowest) lowest = prices[i];
			res = Math.max(res, prices[i] - lowest);
		}
		return res;
	}
}