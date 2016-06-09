public class O230KthSmallestElementBSTRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	int count = 0;
	int res = -1;
	
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) return res;
		count = k;
		helper(root);
		return res;
	}
	
	private void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		if (--count == 0) {
			res = root.val;
			return;
		}
		helper(root.right);
	}
}