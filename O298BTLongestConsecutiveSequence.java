public class O298BTLongestConsecutiveSequence {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x;}
	}
	/*
	int resMax = Integer.MIN_VALUE;
	public int longestConsecutiveSequence(TreeNode root) {
		if (root == null) return 0;
		helper(root, 0, root.val);
		return resMax;
	}
	
	private void helper(TreeNode node, int localMax, int target) {
		if (node == null) {
			return;
		}
		else if (node.val == target) {
			localMax++;
		}
		else {
			localMax = 1;
		}
		resMax = Math.max(resMax, localMax);
		helper(node.left, localMax, node.val + 1);
		helper(node.right, localMax, node.val + 1);
	}
	*/
	public int longestConsecutiveSequence(TreeNode root) {
		int[] res = new int[1];
		helper(root, 1, res);
		return res[0];
	}
	
	private void helper(TreeNode node, Integer singleRes, int[] res) {
		if (node == null) {
			
			return;
		}
		
		if (node.left == null && node.right == null) {
			res[0] = Math.max(res[0], singleRes);
		}
		
		if (node.left != null) {
			helper(node.left, 1, res);
		}
		
		if (node.right != null) {
			if (node.val + 1 == node.right.val) {
				helper(node.right, singleRes + 1, res);
			}
			else {
				res[0] = Math.max(res[0], singleRes);
				helper(node.right, 1, res);
			}
		}
	}
	
	public static void main(String[] args) {
		O298BTLongestConsecutiveSequence e = new O298BTLongestConsecutiveSequence();
		TreeNode n1 = e.new TreeNode(1);
		TreeNode n2 = e.new TreeNode(3);
		TreeNode n3 = e.new TreeNode(2);
		TreeNode n4 = e.new TreeNode(4);
		TreeNode n5 = e.new TreeNode(5);
		n1.left = null;
		n1.right = n2;
		n2.left = n3;
		n2.right = n4;
		n3.left = null;
		n3.right = null;
		n4.left = null;
		n4.right = n5;
		n5.left = null;
		n5.right = null;
		System.out.println(e.longestConsecutiveSequence(n1));
	}
}