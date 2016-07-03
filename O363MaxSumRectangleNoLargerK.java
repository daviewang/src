import java.util.TreeSet;

public class O363MaxSumRectangleNoLargerK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length  == 0 || matrix[0].length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int res = Integer.MIN_VALUE;
		
		for (int left = 0; left < col; left++) {
			int[] sums = new int[row];
			for (int right = left; right < col; right++) {
				for (int i = 0; i < row; i++) {
					sums[i] += matrix[i][right];
				}
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int currSum = 0;
				for (int i = 0; i < row; i++) {
					currSum += sums[i];
					Integer num = set.ceiling(currSum - k);
					if (num != null) {
						res = Math.max(res, currSum - num);
					}
					set.add(currSum);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O363MaxSumRectangleNoLargerK e = new O363MaxSumRectangleNoLargerK();
		int[][] in =  {{1,0,1},{0,-2,3}};
		e.maxSumSubmatrix(in, 2);
	}
}