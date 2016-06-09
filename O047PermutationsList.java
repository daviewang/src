import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O047PermutationsList {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int[] nums, boolean[] visited) {
		if (singleRes.size() == nums.length) {
			res.add(new ArrayList<>(singleRes));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
				continue;
			}
			if (!visited[i]) {
				singleRes.add(nums[i]);
				visited[i] = true;
				helper(res, singleRes, nums, visited);
				visited[i] = false;
				singleRes.remove(singleRes.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		O047PermutationsList e = new O047PermutationsList();
		int[] nums = {1,1};
		e.permuteUnique(nums);
	}
}