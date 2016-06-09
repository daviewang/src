import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O133CloneGraphDFS {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node.label, newNode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(cloneGraph(neighbor));
		}
		return newNode;
	}
}