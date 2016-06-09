import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class O272ClosestBSTValue {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> closestKValue(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> inOrderStack = inOrder(root, target);
		Stack<Integer> postOrderStack = postOrder(root, target);
		
		while (k > 0) {
			if (inOrderStack.isEmpty()) {
				res.add(postOrderStack.pop());
			}
			else if (postOrderStack.isEmpty()) {
				res.add(inOrderStack.pop());
			}
			else if (Math.abs(inOrderStack.peek() - target) < Math.abs(postOrderStack.peek() - target)) {
				res.add(inOrderStack.pop());
			}
			else {
				res.add(postOrderStack.pop());
			}
		}	
		return res;
	}
	
	private Stack<Integer> inOrder(TreeNode root, double target) {
		Stack<Integer> res = new Stack<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				TreeNode node = stack.pop();
				if (node.val > target) {
					break;
				}
				res.push(node.val);
				root = node.right;
			}
		}
		return res;
	}
	
	private Stack<Integer> postOrder(TreeNode root, double target) {
		Stack<Integer> res = new Stack<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.right;
			}
			else {
				TreeNode node = stack.pop();
				if (node.val < target) {
					break;
				}
				res.push(node.val);
				root = node.left;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O272ClosestBSTValue e = new O272ClosestBSTValue();
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
		
		e.inOrder(n1, 4.1);
		e.postOrder(n1, 4.1);
	}
}