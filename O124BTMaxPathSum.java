public class O124BTMaxPathSum {
	public class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x;}
	}
	int maxRes = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return maxRes;
	}
	
	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftMax = helper(node.left);
		int rightMax = helper(node.right);
		int currSum = Math.max(Math.max(leftMax + node.val, rightMax + node.val), node.val);
		int currMax = Math.max(leftMax + rightMax + node.val, currSum);
		return Math.max(currMax, maxRes);
	}
}