import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O210CourseScheduleIIBFS {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] level = new int[numCourses];
		int[] res = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			graph.get(pre[1]).add(pre[0]);
			level[pre[0]]++;
		}
		
		for (int i = 0; i < numCourses; i++) {
			if (level[i] == 0)
				queue.offer(i);
		}
		int resIdx = 0;
		while (!queue.isEmpty()) {
			int courseIdx = queue.poll();
			res[resIdx++] = courseIdx;
			for (int i = 0; i < graph.get(courseIdx).size(); i++) {
				level[graph.get(courseIdx).get(i)]--;
				if (level[graph.get(courseIdx).get(i)] == 0)
					queue.offer(graph.get(courseIdx).get(i));
			}
		}
		if (resIdx == numCourses) {
			return res;
		}
		else {
			return new int[0];
		}
	}
}