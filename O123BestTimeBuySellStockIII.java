public class O123BestTimeBuySellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int[] leftRight = new int[prices.length];
		leftRight[0] = 0;
		int[] rightLeft = new int[prices.length];
		rightLeft[prices.length - 1] = 0;
		
		int lowest = prices[0];
		int leftMax = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			}
			leftMax = Math.max(leftMax, prices[i] - lowest);
			leftRight[i] = leftMax;
		}
		
		int highest = prices[prices.length - 1];
		int rightMax = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > highest) {
				highest = prices[i];
			}
			rightMax = Math.max(rightMax, highest - prices[i]);
			rightLeft[i] = rightMax;
		}
		
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, leftRight[i] + rightLeft[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		O123BestTimeBuySellStockIII e = new O123BestTimeBuySellStockIII();
		int[] in = {2,1,2,0,1};
		e.maxProfit(in);
	}
}