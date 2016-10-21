import java.util.*;

public class O417PacificAtlanticWaterFlowDFS {
    public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] PV = new boolean[row][col];
		boolean[][] AV = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			helper(matrix, PV, i, 0);
			helper(matrix, AV, i, col - 1);
		}
		
		for (int j = 0; j < col; j++) {
			helper(matrix, PV, 0, j);
			helper(matrix, AV, row - 1, j);
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (PV[i][j] & AV[i][j]) {
					res.add(new int[]{i, j});
				}
			}
		}
		return res;
    }
	
	private void helper(int[][] matrix, boolean[][] isAccess, int x, int y) {
		isAccess[x][y] = true;
		int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
		for (int[] dir : dirs) {
			int nextX = x + dir[0];
			int nextY = y + dir[1];
			if (nextX >= 0 && nextY >= 0 && nextX < matrix.length 
				&& nextY < matrix[0].length && matrix[x][y] <= matrix[nextX][nextY] && !isAccess[nextX][nextY]) {
					helper(matrix, isAccess, nextX, nextY);
			}
		}
	}
}