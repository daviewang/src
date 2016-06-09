import java.util.List;
import java.util.Map;

public class O063UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0] == 1) 
            return 0;
       int row = obstacleGrid.length;
       int cols = obstacleGrid[0].length;
       obstacleGrid[0][0]=1;

        for (int i = 1; i < cols; i++) {
        	if (obstacleGrid[0][i] == 1)
        		obstacleGrid[0][i] = 0;
        	else
        		obstacleGrid[0][i] = obstacleGrid[0][i-1];
        }

        for (int i = 1; i < row; i++) {
        	if (obstacleGrid[i][0] == 1)
        		obstacleGrid[i][0] = 0;
        	else 
        		obstacleGrid[i][0] = obstacleGrid[i-1][0];
        }
        
        for (int i = 1; i < row; i++)
        	for (int j = 1; j < cols; j++) {
        		if (obstacleGrid[i][j] == 1)
        			obstacleGrid[i][j] = 0;
        		else 
        			obstacleGrid[i][j] = obstacleGrid[i-1][j] +
        								 obstacleGrid[i][j-1];
        	}
        return obstacleGrid[row -1 ][cols - 1];
	}
	
	class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	///////////////////////////////////
	private static int[][] grid;
	private boolean isFree(int x, int y) {
		if (grid[x][y] == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean getPath(int x, int y, List<Point> path, Map<Point, Boolean> cache) {
		Point p = new Point(x, y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		if (x == 0 && y == 0) {
			path.add(p);
			return true;
		}
		boolean success = false;
		if (x >= 1 && isFree(x - 1, y)) {
			success = getPath(x - 1, y, path, cache);
		}
		if (!success && y >= 1 && isFree(x, y - 1)) {
			success = getPath(x, y - 1, path, cache);
		}
		if (success) {
			path.add(p);
		}
		cache.put(p, success);
		return success;
	}
}