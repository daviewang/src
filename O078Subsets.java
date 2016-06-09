import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O078Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(nums, res, new ArrayList<>(), 0);
		return res;
	}
	private void helper(int[] nums, List<List<Integer>> res, List<Integer> singleRes, int start) {
		res.add(new ArrayList<>(singleRes));
		for (int i = start; i < nums.length; i++) {
			singleRes.add(nums[i]);
			helper(nums, res, singleRes, i + 1);
			singleRes.remove(singleRes.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] in = {1,2,3};
		O078Subsets e = new O078Subsets();
		e.subsets(in);
	}
}