public class O035SearchInsertPos {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		int begin = 0;
		int end = nums.length - 1;
		while(begin <= end) {
			int mid = begin + (end - begin) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[mid] < target) {
				begin = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return begin;
	}
}