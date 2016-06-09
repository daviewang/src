import java.util.Stack;

public class O285InorderSuccessorBSTIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			else {
				TreeNode t = stack.pop();
				if (p.val < t.val) {
					return t;
				}
				curr = t.right;
			}
		}
		return null;
	}
}