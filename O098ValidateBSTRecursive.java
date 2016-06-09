public class O098ValidateBSTRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { x = val;}
	}
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean helper(TreeNode node, long minVal, long maxVal) {
		if (node == null) {
			return true;
		}
		if (node.val >= maxVal || node.val <= minVal) {
			return false;
		}
		return helper(node.left, minVal, node.val) &
			   helper(node.right, node.val, maxVal);
	}
}