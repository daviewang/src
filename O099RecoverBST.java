import java.util.Stack;

public class O099RecoverBST {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x; }
	}
	public void recoverTree(TreeNode root) {
		if (root == null) return;
		TreeNode firstNode = null;
		TreeNode secondNode = null;
		boolean isFirstHit = false;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				TreeNode node = stack.pop();
				if (pre != null && pre.val >= node.val) {
					if (!isFirstHit) {
						firstNode = pre;
						secondNode = node;
						isFirstHit = true;
					}
					else {
						secondNode = node;
						break;
					}
				}
				pre = node;
				root = node.right;
			}
		}
		swapVal(firstNode, secondNode);
	}
	
	private void swapVal(TreeNode n1, TreeNode n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}
	
	public static void main(String[] args) {
		O099RecoverBST e = new O099RecoverBST();
		TreeNode n1 = e.new TreeNode(3);
		TreeNode n2 = e.new TreeNode(1);
		TreeNode n3 = e.new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		n2.left = null;
		n2.right = null;
		n3.left = null;
		n3.right = null;
		e.recoverTree(n1);
	}
}