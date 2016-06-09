import java.util.Stack;

public class O227BasicCalcII {
	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int curr = 0;
		char signal = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				curr = 0;
				curr = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					curr = curr * 10 + s.charAt(i + 1) - '0';
					i++;
				}
			}
			if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1){			
				if (signal == '+') {
					stack.push(curr);
				}
				if (signal == '-') {
					stack.push(-curr);
				}
				if (signal == '*') {		
					stack.push(stack.pop() * curr);
				}
				if (signal == '/') {	
					stack.push(stack.pop() / curr);
				}
				signal = c;
			}
		}
		int res = 0;
		for (Integer i : stack) {
			res += i;
		}
		return res;
	}
	public static void main(String[] args) {
		O227BasicCalcII e = new O227BasicCalcII();
		e.calculate("3*4");
	}
}