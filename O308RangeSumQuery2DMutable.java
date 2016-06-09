public class O308RangeSumQuery2DMutable {
	int[][] colSum;
	int[][] matrix;
	public O308RangeSumQuery2DMutable(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		this.matrix = matrix;
		colSum = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			colSum[0][i] = matrix[0][i];
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				colSum[i][j] = colSum[i - 1][j] + matrix[i][j];
			}
		}
	}
	
	public void update(int row, int col, int val) {
		for (int i = row; i < colSum.length; i++) {
			colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
		}
		matrix[row][col] = val;
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int res = 0;
		for (int i = col1; i <= col2; i++) {
			if (row1 == 0) {
				res += colSum[i][row2];
			}
			else {
				res += colSum[row2][i] - colSum[row1 - 1][i];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] in =  {{3, 0, 1, 4, 2},
				  	   {5, 6, 3, 2, 1},
				  	   {1, 2, 0, 1, 5},
				  	   {4, 1, 0, 1, 7},
				  	   {1, 0, 3, 0, 5}};
		O308RangeSumQuery2DMutable e = new O308RangeSumQuery2DMutable(in);
		System.out.println(e.sumRegion(2, 1, 4, 3));
		e.update(3, 2, 2);
		System.out.println(e.sumRegion(2, 1, 4, 3));
	}
}