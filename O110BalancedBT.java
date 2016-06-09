public class O110BalancedBT {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x; }
	}
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int left = maxdepth(root.left);
		int right = maxdepth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int maxdepth(TreeNode node) {
		if (node == null) return 0;
		return Math.max(maxdepth(node.left), maxdepth(node.right)) + 1;
	}
}