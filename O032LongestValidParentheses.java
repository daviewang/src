import java.util.Stack;

public class O032LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c ==')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
			}
			else {
				stack.push(i);
			}
		}
		if (stack.isEmpty()) return s.length();
		int res = 0;
		int a = s.length();
		int b = 0;
		while(!stack.isEmpty()) {
			b = stack.pop();
			//a-b个间隔，a-b-1个元素
			int singleRes = a - b - 1;
			res = Math.max(res, singleRes);
			a = b;
		}
		// ())
		res = Math.max(res, a);
		return res;
	}
	public static void main(String[] args) {
		O032LongestValidParentheses e = new O032LongestValidParentheses();
		e.longestValidParentheses(")()(())");
	}
}