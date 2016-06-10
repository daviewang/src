import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class O310MinHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<>();
		if (n < 2) {
			leaves.add(0);
			return leaves;
		}
		
		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new HashSet<>());
		}		
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				// 0 - [3], 3 - [0, 1, 2] sample 2
				int j = graph.get(i).iterator().next(); // j = 3
				graph.get(j).remove(i); // now 3 - [1, 2]
				if (graph.get(j).size() == 1) {
					newLeaves.add(j);
				}
			}
			leaves = newLeaves;
		}
		return leaves;
	}
}