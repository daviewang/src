public class O230KthSmallestElementBSTBinarySearch {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public int kthSmallest(TreeNode root, int k) {
		int leftCount = countNodes(root.left);
		if (leftCount + 1 < k) {
			return kthSmallest(root.right, k - leftCount - 1);
		}
		else if (leftCount + 1> k) {
			return kthSmallest(root.left, k);
		}
		else {
			return root.val;
		}
	}
	
	private int countNodes(TreeNode node) {
		if (node == null) return 0;
		return countNodes(node.left) + countNodes(node.right) + 1;
	}
}