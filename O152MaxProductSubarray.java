public class O152MaxProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxCurr = nums[0];
		int minCurr = nums[0];
		int res = nums[0];
	
		for (int i = 1; i < nums.length; i++) {
			int temp = maxCurr;
			maxCurr = Math.max(Math.max(maxCurr * nums[i], minCurr * nums[i]), nums[i]);
			minCurr = Math.min(Math.min(temp * nums[i], minCurr * nums[i]), nums[i]);
			if (maxCurr > res) {
				res = maxCurr;
			}
		}
		return res;
	}	
}