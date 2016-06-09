import java.util.ArrayList;
import java.util.List;

public class O022GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) return res;
		helper(n, n, res, "");
		return res;
	}
	private void helper(int left, int right, List<String> res, String singleRes) {
		if (left == 0 && right == 0) {
			res.add(singleRes);
		}
		if (left > 0) {
			helper(left - 1, right, res, singleRes + "(");
		}
		if (right > left) {
			helper(left, right - 1, res, singleRes + ")");
		}
	}
}