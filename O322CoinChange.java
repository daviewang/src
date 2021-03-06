import java.util.Arrays;

public class O322CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0) return 0;
		
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		O322CoinChange e = new O322CoinChange();
		int[] in = {1};
		e.coinChange(in, 1);
	}
} 