import java.util.ArrayList;
import java.util.List;

public class O094BTInorderTraversalRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(root, res);
		return res;
	}
	
	private void helper(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);
	}
}