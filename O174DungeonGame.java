public class O174DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}
		int len = dungeon.length;
		int col = dungeon[0].length;
		int[][] dp = new int[len][col];
		
		dp[len - 1][col - 1] = Math.max(-dungeon[len - 1][col - 1], 0);
		for (int i = len - 2; i >= 0; i--) {
			dp[i][col - 1] = Math.max(dp[i + 1][col - 1] - dungeon[i][col - 1], 0);
		}
		for (int i = col - 2; i >= 0; i--) {
			dp[len - 1][i] = Math.max(dp[len - 1][i + 1] - dungeon[len - 1][i], 0);
		}
		
		for (int i = len - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 0);
			}
		}
		return dp[0][0] + 1;
	}
}