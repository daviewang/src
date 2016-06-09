import java.util.ArrayList;
import java.util.List;

public class O145BTPostorderRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(root, res);
		return res;
	}
	public void helper(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		helper(node.left, res);
		helper(node.right, res);
		res.add(node.val);
	}
}