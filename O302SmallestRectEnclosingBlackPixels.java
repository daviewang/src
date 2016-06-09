public class O302SmallestRectEnclosingBlackPixels {
	int xMin = Integer.MAX_VALUE;
	int xMax = Integer.MIN_VALUE;
	int yMin = Integer.MAX_VALUE;
	int yMax = Integer.MIN_VALUE;
	
	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[image.length][image[0].length];
		dfs(image, x, y, visited);
		
		return (xMax - xMin + 1) * (yMax - yMin + 1);
	}
	
	private void dfs(char[][] image, int x, int y, boolean[][] visited) {
		if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0' || visited[x][y]) {
			return;
		}
		xMin = Math.min(xMin, x);
		xMax = Math.max(xMax, x);
		yMin = Math.min(yMin, y);
		yMax = Math.max(yMax, y);
		visited[x ][y] = true;
		dfs(image, x - 1, y, visited);
		dfs(image, x + 1, y, visited);
		dfs(image, x, y - 1, visited);
		dfs(image, x, y + 1, visited);
	}
	
	public static void main(String[] args) {
		O302SmallestRectEnclosingBlackPixels e = new O302SmallestRectEnclosingBlackPixels();
		char[][] in = {
					{'0','0','1','0'},
					{'0','1','1','1'},
					{'0','1','0','0'}
		};
		System.out.println(e.minArea(in, 0, 2));
	}
}