import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class O145BTPostorderIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				res.addFirst(curr.val);
				curr = curr.right;
			}
			else {
				TreeNode t = stack.pop();
				curr = t.left;
			}
		}
		return res;
	}
}