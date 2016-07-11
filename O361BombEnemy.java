public class O361BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int res = 0;
		int rowCache = 0;
		int[] colCache = new int[col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0 || grid[i][j - 1] == 'W') {
					rowCache = 0;
					for (int k = j; k < col && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E') {
							rowCache++;
						}
					}
				}
				if (i == 0 || grid[i - 1][j] == 'W') {
					colCache[j] = 0;
					for (int k = i; k < row && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E') {
							colCache[j]++;
						}
					}
				}
				if (grid[i][j] == '0') {
					res = Math.max(res, rowCache + colCache[j]);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O361BombEnemy e = new O361BombEnemy();
		char[][] grid = {
		{'0', 'E', '0', '0'},
		{'E', '0','W', 'E'},
		{'0', 'E', '0', '0'},
		};
		System.out.println(e.maxKilledEnemies(grid));
	}
}