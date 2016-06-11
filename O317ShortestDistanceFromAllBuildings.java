import java.util.LinkedList;
import java.util.Queue;

public class O317ShortestDistanceFromAllBuildings {
	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[][] dist = new int[row][col];
		int[][] reachNum = new int[row][col];
		int totalBuilding = 0;
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
			if (grid[i][j] == 1) {
				bfs(grid, i, j, dist, reachNum);
				totalBuilding++;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0 && reachNum[i][j] == totalBuilding && dist[i][j] != 0) {
					res = Math.min(res, dist[i][j]);
				}
		}
		if (res == Integer.MAX_VALUE) {
			return -1;
		}
		else {
			return res;
		}
	}
	private void bfs(int[][] grid, int x, int y, int[][] dist, int[][] reachNum) {
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		int level = 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();
				for (int[] dir : dirs) {
					int newX = pos[0] + dir[0];
					int newY = pos[1] + dir[1];
					if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] || grid[newX][newY] != 0) {
						continue;
					}
					dist[newX][newY] += level;
					reachNum[newX][newY]++;
					visited[newX][newY] = true;
					queue.add(new int[]{newX, newY});
				}
			}
		}
	}
	public static void main(String[] args) {
		O317ShortestDistanceFromAllBuildings e = new O317ShortestDistanceFromAllBuildings();
		int[][] grid = {
				{1, 0, 2, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0}
		};
		e.shortestDistance(grid);
	}
}