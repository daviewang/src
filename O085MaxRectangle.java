import java.util.Stack;

public class O085MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					height[j] = 0;
				}
				else {
					height[j] += 1;
				}
			}
			res = Math.max(res, helper(height));
		}
		return res;
	}
	
	private int helper(int[] height) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			}
			else {
				int idx = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, width * height[idx]);
				i--;
			}
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
			res = Math.max(res, width * height[idx]);
		}
		return res;
	}
}