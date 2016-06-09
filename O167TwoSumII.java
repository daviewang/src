public class O167TwoSumII {
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) return res;
		int begin = 0;
		int end = nums.length - 1;
		while (begin < end) {
			if (nums[begin] == target - nums[end]) {
				res[0] = begin + 1;
				res[1] = end + 1;
				return res;
			}
			else if (nums[begin] > target - nums[end]) {
				end--;
			}
			else {
				begin++;
			}
		}
		return res;
	}
	public static void main(String[] arges) {
		O167TwoSumII e = new O167TwoSumII();
		int[] in = {2, 10, 11, 15};
		e.twoSum(in, 9);
	}
}