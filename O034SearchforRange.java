public class O034SearchforRange {
	public int[] searchRange(int[] nums, int target){
		if (nums == null || nums.length == 0) return new int[]{-1, -1};
		
		int begin = 0;
		int end = nums.length - 1;
		int mid = -1;
		
		while (begin <= end) {
			mid = begin + (end - begin) / 2;
			if (nums[mid] == target) {
				break;
			}
			if (nums[mid] < target) {
				begin = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		if (nums[mid] != target) {
			return new int[]{-1, -1};
		}
		else {
			int beginIdx = mid;
			int endIdx = mid;
			while (beginIdx > 0 && nums[beginIdx - 1] == nums[mid]) beginIdx--;
			while (endIdx < nums.length - 1 && nums[endIdx + 1] == nums[mid]) endIdx++;
			return new int[]{beginIdx, endIdx};
		}
	}
	
	public static void main(String[] args) {
		O034SearchforRange e = new O034SearchforRange();
		int[] in = {1};
		e.searchRange(in, 1);
	}
}