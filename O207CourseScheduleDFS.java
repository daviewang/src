import java.util.ArrayList;
import java.util.List;

public class O207CourseScheduleDFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> courses = new ArrayList<>();
		boolean[] visited= new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			courses.get(pre[1]).add(pre[0]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(courses, visited, i))
				return false;
		}
		return true;
	}
	private boolean dfs(List<List<Integer>> courses, boolean[] visited, int course) {
		if (visited[course]) {
			return false;
		}
		else {
			visited[course] = true;
		}
		for (int i = 0; i < courses.get(course).size(); i++) {
			if (!dfs(courses, visited, courses.get(course).get(i))) {
				return false;
			}
		}
		visited[course] = false;
		return true;
	}
}