public class O033SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[mid] < nums[end]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			else {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		O033SearchRotatedSortedArray e = new O033SearchRotatedSortedArray();
		int[] in = {3,5,1};
		e.search(in, 3);
	}
}