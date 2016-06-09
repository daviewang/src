import java.util.Stack;

public class O173BSTIterator {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	Stack<TreeNode> stack;
	
	public O173BSTIterator(TreeNode root) {
		stack = new Stack<>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		TreeNode node = stack.pop();
		int res = node.val;
		node = node.right;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		return res;
	}
}