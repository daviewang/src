public class O312BurstBalloons {
	public int maxCoins(int[] nums) {
		int len = nums.length;
		int[] iNums = new int[len + 2];
		iNums[0] = 1;
		iNums[len + 1] = 1;
		for (int i = 0; i < len; i++) {
			iNums[i + 1] = nums[i];
		}
		
		int[][] dp = new int[len + 2][len + 2];
		//k includes left and right
		for (int k = 1; k <= len; k++) {
			for (int left = 1; left <= len - k + 1; left++) {
				int right = left + k - 1;
				for (int i = left; i <= right; i++) {
					dp[left][right] = Math.max(dp[left][right], 
						dp[left][i - 1] + iNums[left - 1] * iNums[i] * iNums[right + 1] 
									+ dp[i + 1][right]);
				}
			}
		}
		return dp[1][len];
	}
	
	public static void main(String[] args) {
		int[] in = {3, 1, 5, 8};
		O312BurstBalloons e = new O312BurstBalloons();
		e.maxCoins(in);
	}
}