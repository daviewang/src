public class O329LongestIncreasingPathMatrix {
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int[][] cache = new int[matrix.length][matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(matrix, cache, i, j, Integer.MAX_VALUE));
			}
		}
		return res;
	}
	private int dfs(int[][] matrix, int[][] cache, int x, int y, int pre) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] >= pre) return 0;
		if (cache[x][y] != 0) return cache[x][y];
		int res = Math.max(
				  Math.max(dfs(matrix, cache, x - 1, y, matrix[x][y]), dfs(matrix, cache, x + 1, y, matrix[x][y])),
				  Math.max(dfs(matrix, cache, x, y - 1, matrix[x][y]), dfs(matrix, cache, x, y + 1, matrix[x][y]))
				) + 1;
		cache[x][y] = res;
		return res;
	}
}