import java.util.ArrayList;
import java.util.List;

public class O199BTRightSideViewRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		helper(root, res, 1);
		return res;
	}
	
	public void helper(TreeNode node, List<Integer> res, int depth) {
		if (node == null) return;
		if (res.size() < depth) res.add(node.val);
		helper(node.right, res, depth + 1);
		helper(node.left, res, depth + 1);
	}
}