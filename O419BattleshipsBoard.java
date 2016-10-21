public class O419BattleshipsBoard {
	int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int countBattleships(char[][] board) {
		int res = 0;
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X' && !isVisited[i][j]) {
					dfs(board, isVisited, i, j);
					res++;
				}
			}
		}
		return res;
    }
	
	private void dfs(char[][] board, boolean[][] isVisited, int x, int y) {
		if (isVisited[x][y]) {
			return;
		}
		isVisited[x][y] = true;
		for (int[] dir : dirs) {
			int row = x + dir[0];
			int col = y + dir[1];
			if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 'X' && !isVisited[row][col]) {
				dfs(board, isVisited, row, col);
			}	
		}
	}
    
    public static void main(String[] args) {
    	O419BattleshipsBoard e = new O419BattleshipsBoard();
    	char[][] board = {
    			{'X','.','.','X'},
    			{'.','.','.','X'},
    			{'.','.','.','X'},
    	};
    	System.out.println(e.countBattleships(board));
    }
}