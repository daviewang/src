public class O106BTInorderPostorderTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return inPostHelper(inorder, 0, inorder.length - 1, 
						    postorder, 0, postorder.length - 1);
	}
	
	private TreeNode inPostHelper(int[] inorder, int inStart, int inEnd,
							      int[] postorder, int postStart, int postEnd) {
		if ((inStart > inEnd) || (postStart > postEnd))return null;
		
		TreeNode node = new TreeNode(postorder[postEnd]);
		
		int leftCount = inStart;
		while(inorder[leftCount] != postorder[postEnd]) {
			leftCount++;
		}
		
		node.left = inPostHelper(inorder, inStart, leftCount - 1,
								 postorder, postStart, postStart + leftCount - inStart - 1);
		node.right = inPostHelper(inorder, leftCount + 1, inEnd, 
								 postorder, postStart + leftCount - inStart, postEnd - 1);
		return node;
	}	
}