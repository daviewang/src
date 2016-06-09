public class O283MoveZeroes {
	public void moveZeros(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int zeroIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[zeroIdx++] = nums[i];
				nums[i] = 0;
			}
		}
	}
}