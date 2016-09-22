import java.util.LinkedList;

public class O071SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		String[] pathArray = path.split("/");
		LinkedList<String> stack = new LinkedList<>();
		for (int i = 0; i < pathArray.length; i++) {
			if (pathArray[i].equals("..")) {
				if (stack.isEmpty()) continue;
				else stack.pop();
			}
			else if (pathArray[i].equals(".") || pathArray[i].equals("")) {
				continue;
			}
			else {
				stack.push(pathArray[i]);
			}
		}
		
		if (stack.isEmpty()) return "/";
		
		StringBuilder sb = new StringBuilder();
		for (int i = stack.size() - 1; i >= 0; i--) {
			sb.append("/" + stack.get(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		O071SimplifyPath e = new O071SimplifyPath();
		e.simplifyPath("/a/./b/");
	}
}