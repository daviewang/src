import java.util.ArrayList;
import java.util.List;

public class O113PathSumII {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res, new ArrayList<>(), sum);
		return res;
	}
	
	private void helper(TreeNode root, List<List<Integer>> res, List<Integer> singleRes, int sum) {
		if (root == null) {
			return;
		}
		singleRes.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			res.add(new ArrayList<Integer>(singleRes));
			//return;
		}
		
		helper(root.left, res, singleRes, sum - root.val);
		helper(root.right, res, singleRes, sum - root.val);
		singleRes.remove(singleRes.size() - 1);
	}
	
	public static void main(String[] args) {
		O113PathSumII e = new O113PathSumII();
		TreeNode l1 = e.new TreeNode(0);
		TreeNode l2 = e.new TreeNode(1);
		TreeNode l3 = e.new TreeNode(1);
		l1.left = l2;
		l1.right = l3;
		l2.left = null;
		l2.right = null;
		l3.left = null;
		l3.right = null;
		e.pathSum(l1, 1);
	}
}