import java.util.Stack;

public class O084LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		int res = 0;
		// Save idx
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			}
			else {
				int idx = stack.pop();
				int width;
				if (!stack.isEmpty()) {
					width = i - stack.peek() - 1;
				}
				else {
					width = i;
				}
				res = Math.max(res, width * height[idx]);
				i--;
			}
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			if (!stack.isEmpty()) {
				res = Math.max(res, height[idx] * (height.length - stack.peek() - 1));
			}
			else {
				res = Math.max(res, height[idx] * height.length);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O084LargestRectangleHistogram e = new O084LargestRectangleHistogram();
		int[] in = {2, 7, 5, 6, 4};
		e.largestRectangleArea(in);
	}
}