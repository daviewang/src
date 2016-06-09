public class O162FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length -1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[mid + 1]) {
				start = mid + 1;
			}
			else if (nums[mid] > nums[mid + 1]) {
				end = mid;
			}
			else {
				return mid;
			}
		}
		return end;
	}
}