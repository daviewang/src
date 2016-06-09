import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class O144BTPreorderIterative {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			if (node.right != null) {
				root = node.right;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O144BTPreorderIterative e = new O144BTPreorderIterative();
		TreeNode t1 = e.new TreeNode(1);
		t1.left = null;
		t1.right = null;
		e.preorderTraversal(t1);
	}
}