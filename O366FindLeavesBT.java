import java.util.List;
import java.util.ArrayList;

public class O366FindLeavesBT {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		helper(root, res);
		return res;
	}
	//从下往上算层数，最下面为0，对应list的index
	private int helper(TreeNode root, List<List<Integer>> res) {
		if (root == null) return -1;
		int level = 1 + Math.max(helper(root.left, res), helper(root.right, res));
		if (res.size() < level + 1) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		return level;
	}
	
	public static void main(String[] args) {
		O366FindLeavesBT e = new O366FindLeavesBT();
		TreeNode t1 = e.new TreeNode(1);
		TreeNode t2 = e.new TreeNode(2);
		TreeNode t3 = e.new TreeNode(3);
		TreeNode t4 = e.new TreeNode(4);
		TreeNode t5 = e.new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		e.findLeaves(t1);
	}
 }