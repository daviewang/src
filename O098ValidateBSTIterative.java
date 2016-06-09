import java.util.Stack;

public class O098ValidateBSTIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x;}
	}
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				TreeNode node = stack.pop();
				if (pre != null && pre.val >= node.val) {
					return false;
				}
				root = node.right;
				pre = node;				
			}
		}
		return true;
	}
}