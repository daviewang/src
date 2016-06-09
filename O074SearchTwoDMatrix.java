public class O074SearchTwoDMatrix {
	public boolean searchMatrix(int[][]matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int start = 0;
		int end = matrix.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (matrix[mid][0] == target) {
				return true;
			}
			else if (matrix[mid][0] < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		if (end < 0) {
			end = 0;
		}
				
		int first = 0;
		int last = matrix[0].length - 1;
		while (first <= last) {
			mid = first + (last - first) / 2;
			if (matrix[end][mid] == target) {
				return true;
			}
			else if (matrix[end][mid] < target) {
				first = mid + 1;
			}
			else {
				last = mid - 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		O074SearchTwoDMatrix e = new O074SearchTwoDMatrix();
		int[][] in =  {{1,1},{2,2}};
		e.searchMatrix(in, 0);
	}
}