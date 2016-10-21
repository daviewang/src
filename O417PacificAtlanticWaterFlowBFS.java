import java.util.*;

public class O417PacificAtlanticWaterFlowBFS {
    public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] PV = new boolean[row][col];
		boolean[][] AV = new boolean[row][col];
		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		
		for (int i = 0; i < row; i++) {
			pQueue.offer(new int[]{i, 0});
			PV[i][0] = true;
			aQueue.offer(new int[]{i, col - 1});
			AV[i][col - 1] = true;
		}
		
		for (int j = 0; j < col; j++) {
			pQueue.offer(new int[]{0, j});
			PV[0][j] = true;
			aQueue.offer(new int[]{row - 1, j});
			AV[row - 1][j] = true;
		}
		bfs(matrix, pQueue, PV);
		bfs(matrix, aQueue, AV);
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (PV[i][j] & AV[i][j]) {
					res.add(new int[]{i, j});
				}
			}
		}
		return res;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] isAccess) {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int[] dir : dirs) {
				int nextX = curr[0] + dir[0];
				int nextY = curr[1] + dir[1];
				if (nextX < 0 || nextY < 0 || nextX >= matrix.length 
					|| nextY >= matrix[0].length || isAccess[nextX][nextY] || matrix[nextX][nextY] < matrix[curr[0]][curr[1]]) {
					continue;
				}
				isAccess[nextX][nextY] = true;
				queue.offer(new int[]{nextX, nextY});
			}
		}
	}
	
	public static void main(String[] args) {
		O417PacificAtlanticWaterFlowBFS e = new O417PacificAtlanticWaterFlowBFS();
		int[][] in = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		e.pacificAtlantic(in);
	}
}