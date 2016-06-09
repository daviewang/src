import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class O210CourseScheduleIIDFS {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			graph.get(pre[1]).add(pre[0]);
		}
		boolean[] isVisited = new boolean[numCourses];
		boolean[] isEnd = new boolean[numCourses];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, i, isVisited, isEnd, stack)) {
				return new int[0];
			}
		}
		
		int[] res = new int[numCourses];
		int idx = 0;
		while(!stack.isEmpty()) {
			res[idx++] = stack.pop();
		}
		return res;
	}
	
	private boolean dfs(List<List<Integer>> graph, int course, boolean[] isEnd, boolean[] isVisited, Stack<Integer> stack) {
		if (isEnd[course]) {
			return true;
		}
		if (isVisited[course]) {
			return false;
		}
		isVisited[course] = true;
		for (int i = 0; i < graph.get(course).size(); i++) {
			if (!dfs(graph, graph.get(course).get(i), isEnd, isVisited, stack)) {
				return false;
			}
		}
		isVisited[course] = false;
		isEnd[course] = true;
		stack.push(course);
		return true;
	}
}