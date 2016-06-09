import java.util.Stack;

public class O156BTUpsideDown {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null || root.right == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode res = root;
		
		while (root != null) {
			res = root;
			stack.push(root.left);
			root = root.left;
		}
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (!stack.isEmpty()) {
				node.left = stack.peek().right;
				node.right = stack.peek();
			}
			else {
				node.left = null;
				node.right = null;
			}
		}
		return res;
	}
}