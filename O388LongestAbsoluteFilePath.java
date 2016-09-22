import java.util.*;

public class O388LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (stack.size() != level) {
                stack.pop();
            }
            int len = s.substring(level).length();
            if (stack.isEmpty()) {
                stack.push(len);
            } else {
                stack.push(stack.peek() + len + 1);
            }
            if (s.contains(".")) {
                result = Math.max(result, stack.peek());
            }
        }
        return result;
    }
	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		O388LongestAbsoluteFilePath e = new O388LongestAbsoluteFilePath();
		e.lengthLongestPath(s);
	}
}