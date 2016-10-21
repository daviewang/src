import java.util.*;

public class O407TrappingRainWaterII {
	class Cell {
		int x, y, height;
		public Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}
	
	public int trapRainWater(int[][] heightMap) {
		int res = 0;
        if (heightMap == null || heightMap.length < 2 || heightMap[0].length < 2) return res;
		
		Comparator<Cell> cp = new Comparator<Cell>(){
			public int compare(Cell a, Cell b) {
				return a.height - b.height;
			}
		};
		
		PriorityQueue<Cell> pq = new PriorityQueue<>(10, cp);
		
		int row = heightMap.length;
		int col = heightMap[0].length;
		boolean[][] isVisited = new boolean[row][col];
		//first row, last row
		for (int i = 0; i < row; i++) {
			pq.offer(new Cell(i, 0, heightMap[i][0]));
			pq.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
			isVisited[i][0] = true;
			isVisited[i][col - 1] = true;
		}
		
		//first col, last col
		for (int i = 1; i < col - 1; i++) {
			pq.offer(new Cell(0, i, heightMap[0][i]));
			pq.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
			isVisited[0][i] = true;
			isVisited[row - 1][i] = true;
		}
		
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!pq.isEmpty()) {
			Cell currCell = pq.poll();
			
			for (int[] dir : dirs) {
				int nextRow = currCell.x + dir[0];
				int nextCol = currCell.y + dir[1];
				if (nextRow > 0 && nextRow < row - 1 && nextCol > 0 && nextCol < col - 1 && !isVisited[nextRow][nextCol]) {
					isVisited[nextRow][nextCol] = true;
					res += Math.max(0, currCell.height - heightMap[nextRow][nextCol]);
					pq.offer(new Cell(nextRow, nextCol, Math.max(currCell.height, heightMap[nextRow][nextCol])));
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[][] in = 
			{
				  {1,4,3,1,3,2},
				  {3,2,1,3,2,4},
				  {2,3,3,2,3,1}
			};
		O407TrappingRainWaterII e = new O407TrappingRainWaterII();
		e.trapRainWater(in);
	}
}