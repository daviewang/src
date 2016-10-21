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
		queue.offer(s);
		boolean isFound = false;
		Set<String> set = new HashSet<>();
		while (!queue.isEmpty() && !isFound) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String temp = queue.poll();
				if (isValid(temp)) {
					isFound = true;
					res.add(temp);
				}
				else {
					for (int j = 0; j < temp.length(); j++) {
						if (temp.charAt(j) == '(' || temp.charAt(j) == ')') {
							String nextLevel = temp.substring(0, j) + temp.substring(j + 1);
							if (!set.contains(nextLevel)) {
								set.add(nextLevel);
								queue.add(nextLevel);
							}
						}
					}
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
		e.removeInvalidParentheses("(k()");		
	}
}