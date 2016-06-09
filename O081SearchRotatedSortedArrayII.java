public class O081SearchRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
				start++;
				end--;
			}
			else if (nums[mid] <= nums[end]) {
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
		return false;
	}
	
	public static void main(String[] args) {
		O081SearchRotatedSortedArrayII e = new O081SearchRotatedSortedArrayII();
		int[] in = {3, 1, 1};
		e.search(in, 3);
	}
}