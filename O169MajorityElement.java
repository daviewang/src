public class O169MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (res == nums[i]) {
				count++;
			}
			else if (count == 0) {
				res = nums[i];
			}
			else {
				count--;
			}
		}
		return res;
	}
}