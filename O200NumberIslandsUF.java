//import java.util.Arrays;

public class O200NumberIslandsUF {
	public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
        UnionFind uf = new UnionFind(grid);  
        int rows = grid.length;  
        int cols = grid[0].length;  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {  
                	int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;  
    }
    class UnionFind {
        int[] roots;  
        int row, len;
        int count = 0;
        UnionFind(char[][] grid) {  
            row = grid.length;  
            len = grid[0].length;  
            roots = new int[row * len];  
            for (int i = 0; i < row; i++) {  
                for (int j = 0; j < len; j++) {  
                    if (grid[i][j] == '1') {
                        int pos	= i * len + j;
                        roots[pos] = pos;
                        count++;
                    }
                }  
            }  
        }
        public void union(int pos1, int pos2) {  
            int root1 = findRoot(pos1);
            int root2 = findRoot(pos2);
            if(root1 != root2) {
                roots[root1] = root2;
                count--;
            }
        }
        public int findRoot (int pos) {  
            while(roots[pos] != pos) {
				roots[pos] = roots[roots[pos]];
				pos = roots[pos];
			}
			return pos;
        }
    }
}