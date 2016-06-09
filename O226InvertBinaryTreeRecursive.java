public class O226InvertBinaryTreeRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x){val = x;}
	}
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode tmpNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmpNode);
		return root;
	}
}