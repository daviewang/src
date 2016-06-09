import java.util.LinkedList;
import java.util.Queue;

public class O101SymmetricTreeIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);
		
		while(!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if (node1 == null ^ node2 == null) return false;
			if (node1 != null && node2 != null) {
				if (node1.val != node2.val) return false;
				else {
					queue.offer(node1.left);
					queue.offer(node2.right);
					queue.offer(node1.right);
					queue.offer(node2.left);
				}
			}
		}
		return true;
	}
}