import java.util.Stack;

public class O394DecodeString {
	public String decodeString(String s) {
        if (s == null || s.length() == 0) {
			return s;
		}
		Stack<String> resStack = new Stack<>();
		Stack<Integer> countStack = new Stack<>();
		String res = "";
		
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (Character.isDigit(c)) {
				int count = 0;
				while (Character.isDigit(c)) {
					count = 10 * count + (c - '0');
					c = s.charAt(++idx);
				}
				countStack.push(count);
			}
			else if (c == '[') {
				resStack.push(res);
				res = "";
				idx++;
			}
			else if (c == ']') {
				StringBuilder sb = new StringBuilder(resStack.pop());
				int count = countStack.pop();
				for (int i = 0; i < count; i++) {
					sb.append(res);
				}
				res = sb.toString();
				idx++;
			}
			else {
				res += c;
				idx++;
			}
		}
		return res;
    }
}