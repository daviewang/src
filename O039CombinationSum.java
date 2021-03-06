import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O039CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);
		helper(candidates, target, new ArrayList<>(), res, 0);
		return res;
	}
	private void helper(int[] candidates, int target, List<Integer> singleRes, List<List<Integer>> res, int pos) {
		if (target == 0) {
			res.add(new ArrayList<>(singleRes));
		}
		if (target < 0) {
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			singleRes.add(candidates[i]);
			helper(candidates, target - candidates[i], singleRes, res, i);
			singleRes.remove(singleRes.size() - 1);
		}
	}
}