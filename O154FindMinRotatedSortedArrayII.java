public class O154FindMinRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int begin = 0;
		int end = nums.length - 1;
		while (begin < end) {
			int mid = begin + (end - begin) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			}
			else if (nums[mid] > nums[end]){
				begin = mid + 1;
			}
			else {
				end--;
			}
		}
		return nums[end];
	}
}