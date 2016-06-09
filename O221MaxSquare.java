public class O221MaxSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return 0;
		int row = matrix.length, col = matrix[0].length;
		int[][] dp = new int[row][col];
		int res = 0;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				res = 1;
			}
		}
		
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
				res = 1;
			}
		}
		
		for (int i = 1; i < row; i++) 
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min( Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] ) + 1; 
					res = Math.max(res, dp[i][j]);
				}
		}
		return res * res;
	}
}