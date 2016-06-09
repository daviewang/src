import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class O094BTInorderTraversalIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			res.add(node.val);
			root = node.right;
		}
		return res;
	}
}