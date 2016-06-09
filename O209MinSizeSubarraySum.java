public class O209MinSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int startPT = 0;
		int endPT = 0;
		int sum = 0;
		int len = nums.length;
		while(startPT < len && endPT < len) {
			while(sum < s && endPT < len) {
				sum += nums[endPT];
				endPT++;
			}
			while(sum >= s && startPT < len) {
				res = Math.min(res, endPT - startPT);
				sum -= nums[startPT];
				startPT++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	public static void main(String[] args) {
		O209MinSizeSubarraySum e = new O209MinSizeSubarraySum();
		int[] in = {2,3,1,2,4,3};
		e.minSubArrayLen(7, in);
	}
}