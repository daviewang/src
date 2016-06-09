public class O059SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int count = 1;
		if (n == 0) return res;
		int level = (n + 1) / 2;
		for (int i = 0; i < level; i++) {
			for (int j = i; j < n - i; j++) {
				res[i][j] = count++;
			}
			for (int j = i + 1; j < n - i; j++) {
				res[j][n - 1 - i] = count++;
			}
			for (int j = n - 2 - i; j >= i; j--) {
				res[n - 1 - i][j] = count++;
			}
			for (int j = n - 2 - i; j > i; j--) {
				res[j][i] = count++;
			}
		}
		return res;
	}
}