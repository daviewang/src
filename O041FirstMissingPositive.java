public class O041FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) return 1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] >= nums.length || nums[i] == nums[nums[i] - 1]) { //【1，1】
					break;
				}
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
}