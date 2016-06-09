public class O052NQueensII {
	int res;
	public int totalNQueens(int n) {
		res = 0;
		if (n == 0) return res;
		dfs(n, 0, new int[n]);
		return res;
	}
	private void dfs(int nQueens, int row, int[] nums) {
		if (row == nQueens) {
			res++;
			return;
		}
		for (int i = 0; i < nQueens; i++) {
			nums[row] = i;
			if (isValid(nums, row)) {
				dfs(nQueens, row + 1, nums);
			}
		}
	}
	private boolean isValid(int[] nums, int row) {
		for (int i = 0; i < row; i++) {
			if (nums[i] == nums[row] || 
					Math.abs(nums[i] - nums[row]) == row - i) {
				return false;
			}
		}
		return true;
	}
}