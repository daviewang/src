public class O348TicTacToe {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;
	
	public O348TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
	}
	
	public int move(int row, int col, int player) {
		int addOn = player == 1 ? 1 : -1;
		rows[row] += addOn;
		cols[col] += addOn;
		if (row == col) 
			diagonal += addOn;
		
		if (col == (cols.length - 1 - row))
			antiDiagonal += addOn;
		
		if (Math.abs(rows[row]) == rows.length ||
			Math.abs(cols[col]) == cols.length ||
			Math.abs(diagonal) == rows.length ||
			Math.abs(antiDiagonal) == rows.length) {
				return player;
			}
		return 0;
	}
}

