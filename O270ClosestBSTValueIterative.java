public class O270ClosestBSTValueIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public int closestValue(TreeNode root, double target) {
		if (root == null) return 0;
		double delta = Double.MAX_VALUE;
		int res = root.val;
		
		while (root != null) {
			if (target == root.val) {
				return root.val;
			}
			else if (target > root.val) {
				if (target - root.val < delta) {
					delta = target - root.val;
					res = root.val;
				}
				root = root.right;
			}
			else {
				if (root.val - target < delta) {
					delta = root.val - target;
					res = root.val;
				}
				root = root.left;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		O270ClosestBSTValueIterative e = new O270ClosestBSTValueIterative();
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
		
		System.out.println(e.closestValue(n1, 6.9));
	}
}