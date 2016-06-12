public class O321CreateMaxNum {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		int len1 = nums1.length;
		int len2 = nums2.length;
		// i is the number of item, not the idx
		for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
			int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(candidate, 0, res, 0)) {
				res = candidate;
			}
		}
		return res;
	}
	
	private int[] maxArray(int[] nums, int k) {
		int[] res = new int[k];
		int stackPoint = 0;
		
		for (int i = 0; i < nums.length; i++) {
			while (nums.length - i > k - stackPoint && // left elements could fill the stack with k size
				stackPoint > 0 &&
				res[stackPoint - 1] < nums[i]) {
				stackPoint--;
			}
			if (stackPoint < k)  { // stackPoint equals the number of stacks elements
				res[stackPoint ++] = nums[i];
			}
		}
		return res;
	}
	
	private boolean greater(int[] nums1, int i, int[] nums2, int j) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		while (i < len1 && j < len2 && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == len2 || (i < len1 && nums1[i] > nums2[j]);
	}
	
	private int[] merge(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; r++) {
			res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		}
		return res;
	}
}