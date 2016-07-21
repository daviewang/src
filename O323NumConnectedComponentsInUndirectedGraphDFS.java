import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class O323NumConnectedComponentsInUndirectedGraphDFS {
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
				visited.add(i);
				dfs(graph, visited, i);
				res++;
			}
		}
		return res;
	}
	
	private void dfs(List<List<Integer>> graph, Set<Integer> visited, int vertex) {
		for (int i = 0; i < graph.get(vertex).size(); i++) {
			if (!visited.contains(graph.get(vertex).get(i))) {
				visited.add(graph.get(vertex).get(i));
				dfs(graph, visited, graph.get(vertex).get(i));
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
				visited[i] = true;
				dfs(graph, visited, i);
				res++;
			}
		}
		return res;
	}
	private void dfs(List<List<Integer>> graph, boolean[] visited, int vertex) {
		for (int i = 0; i < graph.get(vertex).size(); i++) {
			if (!visited[graph.get(vertex).get(i)]) {
				visited[graph.get(vertex).get(i)] = true;
				dfs(graph, visited, graph.get(vertex).get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		O323NumConnectedComponentsInUndirectedGraphDFS e = new O323NumConnectedComponentsInUndirectedGraphDFS();
		int[][] edges = {{0,1},{1,2},{3,4}};
		System.out.println(e.countComponents(5, edges));
	}
}