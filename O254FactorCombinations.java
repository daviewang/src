import java.util.ArrayList;
import java.util.List;

public class O254FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n <= 2) {
			return res;
		}
		helper(res, new ArrayList<Integer>(), n, 2);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> singleRes, int n, int start) {
		if (n <= 1 && singleRes.size() > 1) {
			res.add(new ArrayList<>(singleRes));
		}
		else {
			for (int i = start; i <= n; i++) {
				if (n % i == 0) {
					singleRes.add(i);
					helper(res, singleRes, n / i, i);
					singleRes.remove(singleRes.size() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		O254FactorCombinations e = new O254FactorCombinations();
		e.getFactors(32);
	}
}