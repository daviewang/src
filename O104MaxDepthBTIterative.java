import java.util.LinkedList;
import java.util.Queue;

public class O104MaxDepthBTIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int len = 1;
		
		while(!queue.isEmpty()) {
			len = queue.size();
			while(len-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res++;
		}
		return res;
	}
}