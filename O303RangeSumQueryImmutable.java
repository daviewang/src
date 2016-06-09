public class O303RangeSumQueryImmutable {
	int[] sumArrays;
	public O303RangeSumQueryImmutable(int[] nums) {
		if (nums == null || nums.length == 0) return;
		sumArrays = new int[nums.length];
		sumArrays[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumArrays[i] = sumArrays[i - 1] + nums[i];
		}
	}
	
	public int sumRange(int begin, int end) {
		if (begin == 0) {
			return sumArrays[end];
		}
		else {
			return sumArrays[end] - sumArrays[begin - 1];
		}
	}
}