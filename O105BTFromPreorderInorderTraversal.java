public class O105BTFromPreorderInorderTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return preInHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private TreeNode preInHelper(int[] preorder, int preStart, int preEnd,
								 int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd) return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int leftCount = inStart;
		while (inorder[leftCount] != preorder[preStart]) {
			leftCount++;
		}
		node.left = preInHelper(preorder, preStart + 1, preStart + leftCount - inStart,
								inorder, inStart, leftCount - 1);
		node.right = preInHelper(preorder, preStart + leftCount - inStart + 1, preEnd, 
							     inorder, leftCount + 1, inEnd);
		return node;
	}
}