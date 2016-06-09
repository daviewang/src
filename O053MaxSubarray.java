public class O053MaxSubarray {
	public int maxSubArray(int[] nums) {
		int globalMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum >= 0) {
				sum += nums[i];
			}
			else {
				sum = nums[i];
			}
			globalMax = Math.max(globalMax, sum);
		}
		return globalMax;
	}
}