public class O114FlattenBTLinkedList {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public void flattern(TreeNode root) {
		if (root == null) return;
		TreeNode node = root;
		while (node != null) {
			if(node.left != null) {
				TreeNode temp = node.left;
				while (temp.right != null) temp = temp.right;
				temp.right = node.right;
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}
	}
}