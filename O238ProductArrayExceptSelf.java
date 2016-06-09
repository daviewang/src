public class O238ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		int left = 1;
		int right = 1;
		
		for (int i = 0; i < len; i++) {
			if (i > 0) {
				left = nums[i - 1] * left;
			}
			res[i] = left;
		}
		
		for (int i = len - 1; i >= 0; i--) {
			if (i < len - 1) {
				right = nums[i + 1] * right;
			}
			res[i] *= right;
		}
		return res;
	}
}