import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O199BTRightSideViewIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		Queue<TreeNode> queue = new LinkedList<>();
		int size = 0;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
				if (size == 1) res.add(node.val);
				size--;
			}
		}
		return res;
	}
}