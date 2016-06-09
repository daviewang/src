import java.util.ArrayList;
import java.util.List;

public class O046Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) 
			return res;
		helper(res, 0, nums);
		return res;
	}
	private void helper(List<List<Integer>> res, int start, int[] nums) {
		if (start == nums.length) {
			List<Integer> singleRes = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				singleRes.add(nums[i]);
			}
			res.add(singleRes);
			return;
		}
		for(int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			helper(res, start + 1, nums);
			swap(nums, start, i);
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}