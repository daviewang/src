public class O045JumpGameII {
	public int jump(int[] nums) {
		int currMax = 0;
		int currRch = 0; // idx of array
		int res = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (i > currRch) {
				res++;
				currRch = currMax;
				if (currRch >= nums.length - 1) return res;
			}
			currMax = Math.max(currMax, i + nums[i]);
		}
		return res;
	}
}