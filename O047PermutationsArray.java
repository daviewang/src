import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O047PermutationsArray {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		//Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		helper(res, new ArrayList<>(), nums, visited);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int[] nums, boolean[] visited) {
		if (singleRes.size() == nums.length) {
			res.add(new ArrayList<>(singleRes));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				singleRes.add(nums[i]);
				visited[i] = true;
				helper(res, singleRes, nums, visited);
				visited[i] = false;
				singleRes.remove(singleRes.size() - 1);
			}
		}
	}
}