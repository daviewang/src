public class O289GameLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int row = board.length;
		int col = board[0].length;
		
		for (int i = 0; i < row; i++) 
			for (int j = 0; j < col; j++) {
				int x = getCount(board, i, j);
				if ((board[i][j] & 1) == 0) {
					if (x == 3) board[i][j] += 10;
				}
				else {
					if (x == 2 || x == 3) board[i][j] += 10;
				}
		}
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				board[i][j] >>= 10;
		}
	}
	
	private int getCount(int[][] board, int row, int col) {
		int res = 0;
		int[][] deltas = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
		for (int[] delta : deltas) {
			if (row + delta[0] >= 0 && row + delta[0] < board.length && col + delta[1] >= 0 
				&& col + delta[1] < board[0].length && (board[row + delta[0]][col + delta[1]] & 1) == 1) {
				res++;
			}
		}
		return res;
	}
}