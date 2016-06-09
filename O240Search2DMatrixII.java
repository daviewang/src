public class O240Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return false;
		int len = matrix.length;
		int col = matrix[0].length;
		
		int i = 0; int j = col - 1;
		while (i < len && j >= 0) {
			if (matrix[i][j] < target) {
				i++;
			}
			else if (matrix[i][j] > target) {
				j--;
			}
			else {
				return true;
			}
		}
		return false;
	}
}