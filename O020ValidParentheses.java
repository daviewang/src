import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class O020ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) return false;
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			}
			else if (!stack.isEmpty()) {
				char oldChar = stack.pop();
				if (map.get(oldChar) != c)
					return false;
			}
			else {
				return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		O020ValidParentheses e = new O020ValidParentheses();
		System.out.println(e.isValid("()"));
	}
}