public class O250CountUnivalueSubtrees {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	int res = 0;
	public int countUnivalueSubtrees(TreeNode root) {
		helper(root);
		return res;
	}
	
	private boolean helper(TreeNode node) {
		if (node == null) return true;
		boolean isUniLeft = helper(node.left);
		boolean isUniRight = helper(node.right);
		if (isUniLeft && isUniRight) {
			if (node.left != null && node.left.val != node.val) {
				return false;
			}
			if (node.right != null && node.right.val != node.val) {
				return false;
			}
			res++;
			return true;
		}
		return false;
	}
}