import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O107BTLevelOrderTraversalII {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x){val = x;}
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int size = 0;
		
		while (!queue.isEmpty()) {
			List<Integer> singleRes = new ArrayList<>();
			size = queue.size();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				singleRes.add(node.val);
			}
			res.add(0, singleRes);
		}
		//Collections.reverse(res);
		return res;
	}
}