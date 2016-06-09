public class O260SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int n = nums[0];
		int[] res = {0, 0};
		for (int i = 1; i < nums.length; i++) {
			n ^= nums[i];
		}
		
		n &= (~(n - 1));
		
		for (int i = 0; i < nums.length; i++) {
			if ((n & nums[i]) == 0) {
				res[0] ^= nums[i];
			}
			else {
				res[1] ^= nums[i];
			}
		}
		return res;
	}
}