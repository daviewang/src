public class O026RemoveDupSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int firstH = 0;
		int secondH = 1;
		
		while (secondH < nums.length) {
			if (nums[firstH] != nums[secondH]) {
				firstH++;
				nums[firstH] = nums[secondH];
				secondH++;
			}
			else {
				secondH++;
			}
		}
		return firstH + 1;
	}
}