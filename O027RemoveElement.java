public class O027RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) return 0;
		int dupCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				dupCount++;
			}
			else {
				nums[i - dupCount] = nums[i];
			}
		}
		return nums.length - dupCount;
	}
}