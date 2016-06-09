import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O103BTZigzagTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int len = 0;
		boolean isReverse = false;
		while(!queue.isEmpty()) {
			LinkedList<Integer> singleRes = new LinkedList<>();
			len = queue.size();
			while (len-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
				
				if (!isReverse) {
					singleRes.add(node.val);
				}
				else {
					singleRes.addFirst(node.val);
				}
			}
			isReverse = !isReverse;
			res.add(singleRes);
		}
		return res;
	}
}