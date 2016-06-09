import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O090SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), 0, nums);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int pos, int[] nums) {
		res.add(new ArrayList<>(singleRes));
		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i - 1]) {
				continue;
			}
			singleRes.add(nums[i]);
			helper(res, singleRes, i + 1, nums);
			singleRes.remove(singleRes.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		O090SubsetsII e = new O090SubsetsII();
		int[] nums = {1, 1};
		e.subsetsWithDup(nums);
	}
}