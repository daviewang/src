public class O037SudokuSolver {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		helper(board);
	}
	
	private boolean helper(char[][] board) {
		for (int i = 0; i < 9; i ++)
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (isValid(board, k, i, j)) {
							board[i][j] = k;
							if (helper(board)) {
								return true;
							}
							else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, char val, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val || board[i][col] == val)
				return false;
		}
		int rowBase = 3 * (row / 3);
		int colBase = 3 * (col / 3);
		for (int i = rowBase; i < rowBase + 3; i ++)
			for (int j = colBase; j < colBase + 3; j++) {
				if (board[i][j] == val)
					return false;
		}
		return true;
	}
}