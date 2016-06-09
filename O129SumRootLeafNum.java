import java.util.ArrayList;
import java.util.List;

public class O129SumRootLeafNum {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x;}
	}
	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		List<Integer> res = new ArrayList<>();
		helper(root, root.val, res);
		int sumNum = 0;
		for (Integer i : res) {
			sumNum += i;
		}
		return sumNum;
	}
	
	private void helper(TreeNode root, int localVal, List<Integer> res) {
		if (root.right != null) {
			helper(root.right, localVal * 10 + root.right.val, res);
		}
		if (root.left != null) {
			helper(root.left, localVal * 10 + root.left.val, res);
		}
		if (root.right == null && root.left == null){
			res.add(localVal);
		}
	}
	
	public static void main(String[] args) {
		O129SumRootLeafNum e = new O129SumRootLeafNum();
		TreeNode n1 = e.new TreeNode(1);
		TreeNode n2 = e.new TreeNode(2);
		TreeNode n3 = e.new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		e.sumNumbers(n1);
	}
}