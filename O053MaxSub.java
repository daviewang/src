public class O053MaxSub {
	public int maxSub(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		//int[] dp = new int[nums.length];
		int resMax = nums[0];
		int singleMax = nums[0];
		//简化dp
		for (int i = 1; i < nums.length; i++) {
			singleMax = Math.max(nums[i], singleMax + nums[i]);
			resMax = Math.max(resMax, singleMax);
		}
		return resMax;
	}
	public static void main(String[] args) {
		O053MaxSub e = new O053MaxSub();
		int[] in = {-2,1,-3,4,-1,2,1,-5,4};
		e.maxSub(in);
	}
}