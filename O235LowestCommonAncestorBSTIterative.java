public class O235LowestCommonAncestorBSTIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			}
			else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			}
			else {
				return root;
			}
		}
	}
}