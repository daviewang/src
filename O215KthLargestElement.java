public class O215KthLargestElement {
	private int partitions(int[] nums, int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true) {
			while(less(nums[++i], nums[lo]))
			if (i == hi) break;
			while(less(nums[lo], nums[--j]))
			if (j == lo) break;
			if (i >= j) break;
			exch(nums, i, j);
		}
		exch(nums, lo, j);
		return j;
	}
	
	private void exch(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private boolean less(int a, int b) {
		return a < b;
	}
	
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lo = 0;
		int hi = nums.length - 1;
		k = nums.length - k;
		while (lo < hi) {
			int j = partitions(nums, lo, hi);
			if (j < k) {
				lo = j + 1;
			}
			else if (j > k){
				hi = j - 1;
			}
			else {
				break;
			}
		}
		return nums[k];
	}
}