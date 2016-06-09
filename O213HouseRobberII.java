public class O213HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		
		int firstRound = getMax(nums, 0, nums.length - 2);
		int secondRound = getMax(nums, 1, nums.length - 1);
		return firstRound < secondRound ? secondRound : firstRound;
	}
	
	private int getMax(int[] nums, int start, int end) {
		int len = end - start + 1;
		int[] dp = new int[len];
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start + 1]);
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i -1], dp[i -2] + nums[i + start]);
		}
		return dp[len - 1];
	}
}