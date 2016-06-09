import java.util.ArrayList;
import java.util.List;

public class O095UniqueBSTII {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if (n == 0) return res;
		return helper(1, n);
	}
	
	public List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new ArrayList<>();
		if (left == right) {
			TreeNode node = new TreeNode(left);
			res.add(node);
			return res;
		}
		if (left > right) {
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftPart = helper(left, i - 1);
			List<TreeNode> rightPart = helper(i + 1, right);
			for (TreeNode l : leftPart) {
				for (TreeNode r : rightPart) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}