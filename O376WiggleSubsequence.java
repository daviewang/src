public class O376WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int first = 1;
		int second = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				first = second + 1;
			}
			if (nums[i - 1] > nums[i]) {
				second = first + 1;
			}
		}
		return Math.max(first, second);
	}			
}