import java.util.Arrays;

public class O016ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int res = 0;
		int delta = Integer.MAX_VALUE;
		if (nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length -2; i++) {
			int twoSumTarget = target - nums[i];
			int singleRes = nums[i] + twoSumClosest(nums, twoSumTarget, i + 1); 
			if (singleRes != target) {
				if (Math.abs(singleRes - target) < delta) {
					res = singleRes;
					delta = Math.abs(singleRes - target);
				}
			}
			else {
				return singleRes;
			}
		}
		return res;
	}
	
	private int twoSumClosest(int[] nums, int target, int startIdx) {
		int delta = Integer.MAX_VALUE;
		int begin = startIdx;
		int end = nums.length - 1;
		int res = 0;
		while (begin < end) {
			if (nums[begin] > target - nums[end]) {
				if (nums[begin] + nums[end] - target < delta) {
					delta = nums[begin] + nums[end] - target;
					res = nums[begin] + nums[end];
				}
				end--;
			}
			else if (nums[begin] < target - nums[end]) {
				if (target - nums[begin] - nums[end] < delta) {
					delta = target - nums[begin] - nums[end];
					res = nums[begin] + nums[end];
				}
				begin++;
			}
			else {
				return target;
			}
		}
		return res;
	}
}