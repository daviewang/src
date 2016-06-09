public class O285InorderSuccessorBSTRecursive {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; };
	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		}
		else {
			TreeNode left = inorderSuccessor(root.left, p);
			if (left == null) {
				return root;
			}
			else {
				return left;
			}
		}
	}
	public static void main(String[] args) {
		O285InorderSuccessorBSTRecursive e = new O285InorderSuccessorBSTRecursive();
		TreeNode l1 = e.new TreeNode(1);
		TreeNode l2 = e.new TreeNode(2);
		TreeNode l3 = e.new TreeNode(3);
		TreeNode l4 = e.new TreeNode(4);
		TreeNode l5 = e.new TreeNode(5);
		TreeNode l6 = e.new TreeNode(6);
		
		l4.left = l2;
		l4.right = l6;
		l2.left = l1;
		l2.right = l3;
		l1.left = null;
		l1.right = null;
		l3.left = null;
		l3.right = null;
		l6.left = l5;
		l6.right = null;
		l5.left = null;
		l5.right = null;
		e.inorderSuccessor(l4, l1);
	}
		
}