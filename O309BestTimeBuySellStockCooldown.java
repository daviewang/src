public class O309BestTimeBuySellStockCooldown {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int len = prices.length;
		int[] s0 = new int[prices.length];
		int[] s1 = new int[prices.length];
		int[] s2 = new int[prices.length];
		
		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = Integer.MIN_VALUE;
		
		for (int i = 1; i < len; i++) {
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return Math.max(s0[len - 1], s2[len - 1]);
	}
}