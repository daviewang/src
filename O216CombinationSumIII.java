import java.util.ArrayList;
import java.util.List;

public class O216CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (k <= 0 || n <= 0) return res;
		helper(res, new ArrayList<>(), n, 1, k);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int target, int start, int count) {
		if (target == 0 && count == 0) {
			res.add(new ArrayList<>(singleRes));
			return;
		}
		if (target < 0 || count <= 0) {
			return;
		}
		for (int i = start; i<= 9; i++) {
			singleRes.add(i);
			helper(res, singleRes, target - i, i + 1, count - 1);
			singleRes.remove(singleRes.size() - 1);
		}
	}
	public static void main(String[] args) {
		O216CombinationSumIII e = new O216CombinationSumIII();
		e.combinationSum3(3, 9);
	}
}