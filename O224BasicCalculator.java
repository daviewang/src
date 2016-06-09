import java.util.Stack;

public class O224BasicCalculator {
	public int calculate(String s) {
		if (s == null || s.length() == 0) 
			return 0;
		int res = 0;
		int signal = 1;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int curr = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					curr = curr * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				res = curr * signal + res;
				signal = 1;
			}
			else if (c == '+') {
				signal = 1;
			}
			else if (c == '-') {
				signal = -1;
			}
			else if (c == '(') {
				stack.push(res);
				stack.push(signal);
				res = 0;
				signal = 1;
			}
			else if (c == ')') {
				res = stack.pop() * res + stack.pop();
				signal = 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O224BasicCalculator e = new O224BasicCalculator();
		e.calculate("1 + 1");
	}
}