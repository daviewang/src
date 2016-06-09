import java.util.ArrayList;
import java.util.List;

public class O051NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n == 0) return res;
		helper(n, new int[n], 0, res);
		return res;
	}
	public void helper(int nQueens, int[] nums, int row, List<List<String>> res) {
		if (row == nQueens) {
			res.add(generateMap(nums));
			return;
		}
		for (int i = 0; i < nQueens; i++) {
			nums[row] = i;
			if (isValid(nums, row)) {
				helper(nQueens, nums, row + 1, res);
			}
		}
	}
	private boolean isValid(int[] nums, int row) {
		for (int i = 0; i < row; i++) {
			if (nums[i] == nums[row] || Math.abs(nums[row] - nums[i]) == row - i)
				return false;
		}
		return true;
	}
	private List<String> generateMap(int[] nums) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < nums.length; j++) {
				if (j == nums[i]) {
					sb.append("Q");
				}
				else {
					sb.append(".");
				}
			}
			res.add(sb.toString());
		}
		return res;
	}
}