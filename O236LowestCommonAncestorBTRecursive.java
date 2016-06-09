public class O236LowestCommonAncestorBTRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		
		if (leftNode != null && rightNode != null) {
			return root;
		}
		if (leftNode == null) {
			return rightNode;
		}
		else {
			return leftNode;
		}
	}
}