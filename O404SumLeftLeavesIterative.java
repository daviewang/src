import java.util.*;
public class O404SumLeftLeavesIterative {
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    queue.offer(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    queue.offer(node.right);
            }
        }
        return ans;
    }
}