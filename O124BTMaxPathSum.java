public class O124BTMaxPathSum {
	public class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x;}
	}
	int maxValue = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		helper(root);
		return maxValue;
	}
	
	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left);
		int right = helper(node.right);
		int res = Math.max(Math.max(left + node.val, right + node.val), node.val);
		int currMax = Math.max(res, left + right + node.val);
		maxValue = Math.max(maxValue, currMax);
		return res;
	}
}