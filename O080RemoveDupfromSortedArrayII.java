public class O080RemoveDupfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int firstH = 0;
		int secondH = 1;
		boolean isFirst = false;
		
		while (secondH < nums.length) {
			if (nums[firstH] != nums[secondH]) {
				firstH++;
				nums[firstH] = nums[secondH];
				secondH++;
				isFirst = false;
			}
			else if (!isFirst){
				firstH++;
				nums[firstH] = nums[secondH];
				secondH++;
				isFirst = true;
			}
			else {
				secondH++;
			}
		}
		return firstH + 1;
	}
}