import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O297SerializeDeserializeBT {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	private static final String spliter = ",";
	private static final String NN = "X";
	
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NN).append(spliter);
			return;
		}
		else {
			sb.append(root.val).append(spliter);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}
	
	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}
	
	private TreeNode buildTree(Queue<String> nodes) {
		String val = nodes.poll();
		if (val.equals(NN)) {
			return null;
		}
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
}