public class O079WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length ==0) 
			return false;
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, 0, i, j, isVisited)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean dfs(char[][] board, String word, int wordIdx, int x, int y, boolean[][] isVisited) {
		if (wordIdx == word.length()) {
			return true;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
			return false;
		}
		if (board[x][y] != word.charAt(wordIdx) || isVisited[x][y]) {
			return false;
		}
		isVisited[x][y] = true;
		boolean res =
		dfs(board, word, wordIdx + 1, x + 1, y, isVisited) ||
		dfs(board, word, wordIdx + 1, x - 1, y, isVisited) ||
		dfs(board, word, wordIdx + 1, x, y + 1, isVisited) ||
		dfs(board, word, wordIdx + 1, x, y - 1, isVisited);
		isVisited[x][y] = false;
		return res;
	}
	public static void main(String[] args) {
		O079WordSearch e = new O079WordSearch();
		char[][] board = {{'a'}};
		e.exist(board, "ab");
	}
}