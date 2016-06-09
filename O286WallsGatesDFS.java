public class O286WallsGatesDFS {
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j);
				}
			}
		}
	}
	
	private void dfs(int[][] rooms, int row, int col) {
		int[][] deltas = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
		for (int[] delta : deltas) {
			if (row + delta[0] >= 0 && row + delta[0] < rooms.length && col + delta[1] >= 0 
				&& col + delta[1] < 0 && rooms[row + delta[0]][col + delta[1]] > rooms[row][col] + 1) {
					rooms[row + delta[0]][col + delta[1]] = rooms[row][col] + 1;
					dfs(rooms, row + delta[0], col + delta[1]);
			}
		}
	}
}