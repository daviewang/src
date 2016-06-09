import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class O047PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		helper(nums, 0, res);
		return res;
	}
	private void helper(int[] nums, int pos, List<List<Integer>> res) {
		if (pos == nums.length) {
			res.add(getList(nums));
			return;
		}
		Set<Integer> visited = new HashSet<>();
		for (int i = pos; i < nums.length; i++) {
			if (!visited.contains(nums[i])) {
				visited.add(nums[i]);
				swap(nums, pos, i);
				helper(nums, pos + 1, res);
				swap(nums, i, pos);
			}
		}
	}
	private List<Integer> getList(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (Integer i : nums) {
			res.add(i);
		}
		return res;
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}