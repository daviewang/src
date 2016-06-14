import java.util.LinkedList;

public class O353SnakeGame {
	class Position {
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean isEqual(Position p) {
			return this.x == p.x && this.y == p.y;
		}
	}
	LinkedList<Position> snake;
	int[][] food;
	int height;
	int width;
	int snakeLen;
	
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public O353SnakeGame(int width, int height, int[][] food) {
		snake = new LinkedList<>();
		this.height = height;
		this.width = width;
		this.food = food;
		snake.add(new Position(0, 0));
		int snakeLen = 0;
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
		Position curr = new Position(snake.get(0).x, snake.get(0).y);
		switch(direction) {
			case "U":
				curr.y--; 
				break;
			case "D":
				curr.y++;
				break;
			case "R":
				curr.x--;
				break;
			case "L":
				curr.x++;
				break;
		}
		if (curr.x < 0 || curr.y < 0  || curr.x >= width || curr.y >= height) 
			return -1;
		
		for (int i = 1; i < snake.size(); i++) {
			Position next = snake.get(i);
			if (next.isEqual(curr)) {
				return -1;
			}
		}
		
		snake.addFirst(curr);
		if (snakeLen < food.length) {
			Position foodPos = new Position(food[snakeLen][0], food[snakeLen][1]);
			if (curr.isEqual(foodPos)) {
				snakeLen++;
			}
		}
		while(snake.size() >= snakeLen) snake.removeLast();
		return snakeLen;
    }

}
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */