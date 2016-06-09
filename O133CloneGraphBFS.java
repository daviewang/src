import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class O133CloneGraphBFS {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node.label, newNode);
		
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor.label)) {
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				map.get(n.label).neighbors.add(map.get(neighbor.label));
			}
		}
		return newNode;
	}
}