import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class O301RemoveInvalidParenthesesBFS {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();	
		queue.offer(s);
		boolean isFound = false;
		
		while (!queue.isEmpty()) {
			String temp = queue.poll();
			if (isValid(temp)) {
				isFound = true;
				res.add(temp);
			}
			if (isFound) {
				continue;
			}
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) != '(' && temp.charAt(i) != ')') {
					continue;
				}
				String nextLevelStr = temp.substring(0, i) + temp.substring(i + 1);
				if (!set.contains(nextLevelStr)) {
					queue.add(nextLevelStr);
					set.add(nextLevelStr);
				}
			}
		}
		return res;
	}
	
	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			}
			else if (c == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		if (count == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		O301RemoveInvalidParenthesesBFS e = new O301RemoveInvalidParenthesesBFS();
		e.removeInvalidParentheses("()())()");		
	}
}