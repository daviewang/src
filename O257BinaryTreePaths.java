import java.util.ArrayList;
import java.util.List;

public class O257BinaryTreePaths {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res, "");
		return res;
	}
	
	private void helper(TreeNode root, List<String> res, String path) {
		if (root.left == null && root.right == null) {
			res.add(path + root.val);
			return;
		}
		if (root.left != null) {
			helper(root.left, res, path + root.val + "->");
		}
		if (root.right != null) {
			helper(root.right, res, path + root.val + "->");
		}
	}
}