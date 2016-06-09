import java.util.HashSet;
import java.util.Set;

public class O036ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> colSet = new HashSet<>();
			Set<Character> squareSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
					return false;
				}
				else {
					rowSet.add(board[i][j]);
				}
				
				if (board[j][i] != '.' && colSet.contains(board[j][i])) {
					return false;
				}
				else {
					colSet.add(board[j][i]);
				}
				int rowIndex = 3 * (i / 3);
        		int colIndex = 3 * (i % 3);
        		
        		if (board[rowIndex + j/3][colIndex + j % 3] !='.' &&
        			!squareSet.add(board[rowIndex + j/3][colIndex + j % 3]))
        			return false;
			}
		}
		return true;
	}
}