import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O207CourseScheduleBFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		int[] degree = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			graph.get(pre[1]).add(pre[0]);
			degree[pre[0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				count++;
			}
		}
		
		while(!queue.isEmpty()) {
			int courseID = queue.poll();
			for (int i = 0; i < graph.get(courseID).size(); i++) {
				int requiredID = graph.get(courseID).get(i);
				degree[requiredID]--;
				if (degree[requiredID] == 0) {
					queue.add(requiredID);
					count++;
				}
			}
		}
		if (count == numCourses) {
			return true;
		}
		else {
			return false;
		}
	}
}