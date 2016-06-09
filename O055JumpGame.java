public class O055JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1) return true;
		int maxJump = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (maxJump == 0) return false;
			maxJump--;
			if (maxJump < nums[i]) {
				maxJump = nums[i];
			}
			if (maxJump + i >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		O055JumpGame e = new O055JumpGame();
		int[] nums = {0,1};
		System.out.println(e.canJump(nums));
	}
}