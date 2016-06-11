import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class  O314BTVerticalOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			val = x;
		}
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> treeNodeQueue = new LinkedList<>();
		treeNodeQueue.offer(root);
		Queue<Integer> colQueue = new LinkedList<>();
		colQueue.offer(0);
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		int left = 0, right = 0;
		
		while (!treeNodeQueue.isEmpty()) {
			TreeNode node = treeNodeQueue.poll();
			int colIdx = colQueue.poll();
			
			if (!map.containsKey(colIdx)) {
				map.put(colIdx, new ArrayList<>());
			}
			map.get(colIdx).add(node.val);
			
			if (node.left != null) {
				treeNodeQueue.add(node.left);
				colQueue.add(colIdx - 1);
				left = Math.min(left, colIdx - 1);
			}
			
			if (node.right != null) {
				treeNodeQueue.add(node.right);
				colQueue.add(colIdx + 1);
				right = Math.max(right, colIdx + 1);
			}
		}
		for (int i = left; i <= right; i++) {
			res.add(map.get(i));
		}
		return res;
	}
	
	public static void main(String[] args) {
		O314BTVerticalOrderTraversal e = new O314BTVerticalOrderTraversal();
		TreeNode l1 = e.new TreeNode(3);
		TreeNode l2 = e.new TreeNode(9);
		TreeNode l3 = e.new TreeNode(20);
		TreeNode l4 = e.new TreeNode(4);
		TreeNode l5 = e.new TreeNode(5);
		TreeNode l6 = e.new TreeNode(2);
		TreeNode l7 = e.new TreeNode(7);
		l1.left = l2;
		l1.right = l3;
		l2.left = l4;
		l2.right = l5;
		l3.left = l6;
		l3.right = l7;
		l4.left = null;
		l4.right = null;
		l5.left = null;
		l5.right = null;
		l6.left = null;
		l6.right = null;
		l7.left = null;
		l7.right = null;
		e.verticalOrder(l1);
	}
}