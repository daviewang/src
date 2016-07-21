public class O375GuessNumberHigherLowerII {
	public int getMoneyAmount(int n) {
		if (n <= 1) return 0;
		int[][] dp = new int[n + 1][n + 1];
		return helper(dp, 1, n);
	}
	private int helper(int[][] dp, int start, int end) {
		if (start >= end) return 0;
		if (dp[start][end] != 0) return dp[start][end];
		int res = Integer.MAX_VALUE;
		for (int i = start; i <=end; i++) {
			res = Math.min(res, i + Math.max(helper(dp, start, i - 1), helper(dp, i + 1, end)));
		}
		dp[start][end] = res;
		return res;
	}
}