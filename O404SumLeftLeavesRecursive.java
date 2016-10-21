public class O404SumLeftLeavesRecursive {
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    
    private void helper(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            else {
                helper(node.left);
            }
        }
        
        if (node.right != null) {
            helper(node.right);
        }
    }
}