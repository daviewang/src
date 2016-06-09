import java.util.Stack;

public class O230KthSmallestBSTIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	public int kthSmallest(TreeNode root, int k) {
		int count = 0;
		int res = 0;
		Stack<TreeNode> stack = new Stack<>();
		
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				count++;
				TreeNode node = stack.pop();
				if (count == k) {
					res = node.val;
					break;
				}
				if (node.right != null) {
					root = node.right;
				}
			}
		}
		return res;
	}
}