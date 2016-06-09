public class O270ClosestBSTValueRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	double target;
	double delta;
	int res = 0;
	
	public int closestValue (TreeNode root, double target) {
		this.target = target;
		delta = Double.MAX_VALUE;
		helper(root);
		return res;
	}
	
	public void helper(TreeNode node) {
		if (node == null) return;
		if (node.val == target) {
			res = node.val;
			return;
		}
		else if (Math.abs(node.val - target) < delta) {
			delta = Math.abs(node.val - target);
			res = node.val;
		}
		helper(node.left);
		helper(node.right);
	}
	
	public static void main(String[] args) {
		O270ClosestBSTValueRecursive e = new O270ClosestBSTValueRecursive();
		TreeNode n1 = e.new TreeNode(4);
		TreeNode n2 = e.new TreeNode(2);
		TreeNode n3 = e.new TreeNode(6);
		TreeNode n4 = e.new TreeNode(1);
		TreeNode n5 = e.new TreeNode(3);
		TreeNode n6 = e.new TreeNode(5);
		TreeNode n7 = e.new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		System.out.println(e.closestValue(n1, -99797));
	}
	
}