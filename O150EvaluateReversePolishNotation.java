import java.util.Stack;

public class O150EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String c = tokens[i];
			if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				switch(c.charAt(0)) {
					case '+' : 
						stack.push(a + b);
						break;
					case '-' : 
						stack.push(a - b);
						break;
					case '*' : 
						stack.push(a * b);
						break;
					case '/' : 
						stack.push(a / b);
						break;
				}
			}
			else {
				stack.push(Integer.valueOf(c));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		O150EvaluateReversePolishNotation e = new O150EvaluateReversePolishNotation();
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(e.evalRPN(tokens));
	}
}