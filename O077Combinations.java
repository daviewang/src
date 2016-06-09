import java.util.ArrayList;
import java.util.List;

public class O077Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), 1, n, k);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int start, int n, int k) {
		if (k == 0) {
			res.add(new ArrayList<>(singleRes));
			return;
		}
		for (int i = start; i <= n; i++) {
			singleRes.add(i);
			helper(res, singleRes, i + 1, n, k - 1);
			singleRes.remove(singleRes.size() - 1);
		}
	}
}