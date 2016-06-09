public class O112PathSum {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null & root.right == null) {
			return root.val == sum;
		}
		return hasPathSum(root.left, sum - root.val) ||
			   hasPathSum(root.right, sum - root.val);
	}
	
	public static void main(String[] args) {
		O112PathSum e = new O112PathSum();
		TreeNode l1 = e.new TreeNode(1);
		l1.left = null;
		l1.right = null;
		e.hasPathSum(l1, 0);
	}
}