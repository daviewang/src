import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class O323NumConnectedComponentsInUndirectedGraphBFS {
	/*
	public int countComponents(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		Set<Integer> visited = new HashSet<>();
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				res++;
				bfs(graph, visited, i);
			}
		}
		return res;
	}
	
	private void bfs(List<List<Integer>> graph, Set<Integer> visited, int i) {
		Queue<Integer> queue = new LinkedList<>();
		visited.add(i);
		queue.offer(i);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int j : graph.get(curr)) {
				if (!visited.contains(j)) {
					queue.offer(j);
					visited.add(j);
				}
			}
		}
	}
	*/
	
	public int countComponents(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		boolean[] visited = new boolean[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				res++;
				bfs(graph, visited, i);
			}
		}
		return res;
	}
	
	private void bfs(List<List<Integer>> graph, boolean[] visited, int idx) {
		Queue<Integer> queue = new LinkedList<>();
		visited[idx] = true;
		queue.offer(idx);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int i = 0; i < graph.get(curr).size(); i++) {
				if (!visited[graph.get(curr).get(i)]) {
					queue.offer(graph.get(curr).get(i));
					visited[graph.get(curr).get(i)] = true;;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		O323NumConnectedComponentsInUndirectedGraphBFS e = new O323NumConnectedComponentsInUndirectedGraphBFS();
		int[][] edges = {{0,1},{1,2},{3,4}};
		System.out.println(e.countComponents(5, edges));
	}
}