import java.util.LinkedList;
import java.util.Queue;

public class O130SurroundedRegions {
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) return;
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || i == board.length - 1 || j == 0 || j == 0 || j == board[0].length - 1){
					if (board[i][j] == 'O') {
						Pair pair = new Pair(i, j);
						queue.add(pair);
					}
				}
			}
		}
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int x1 = pair.x;
			int y1 = pair.y;
			board[x1][y1] = 'Y';
			
			if (x1 - 1 >= 0 && board[x1 - 1][y1] == 'O') {
				queue.add(new Pair(x1 - 1, y1));
			}
			
			if (x1 + 1 < board.length && board[x1 + 1][y1] == 'O') {
				queue.add(new Pair(x1 + 1, y1));
			}
			
			if (y1 - 1 >= 0 && board[x1][y1 - 1] == 'O') {
				queue.add(new Pair(x1, y1 - 1));
			}
			
			if (y1 + 1 < board[0].length && board[x1][y1 + 1] == 'O') {
				queue.add(new Pair(x1, y1 + 1));
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				else if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
	}
}