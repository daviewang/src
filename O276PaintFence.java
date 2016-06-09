public class O276PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		int[] dp = new int[n];
		dp[1] = k;
		dp[2] = k * k;
		
		for (int i = 3; i < n; i++) {
			dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
		}
		return dp[n - 1];
	}
}