public class O104MaxDepthBTRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return left > right ? left : right;
	}	
}