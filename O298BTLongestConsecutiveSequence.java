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
	int maxVal = 1;
	public int longestConsecutiveSequence(TreeNode root) {
		if (root == null) return 0;
		helper(root, 1);
		return maxVal;
	}
	
	private void helper(TreeNode node, int localMax) {
		if (node == null) {
			maxVal = Math.max(maxVal, localMax - 1);
			return;
		}
		if (node.left != null) {
			if (node.val == node.left.val - 1) {
				helper(node.left, localMax + 1);
			}
			else {
				maxVal = Math.max(maxVal, localMax);
				helper(node.left, 1);
			}
		} 
			
		if (node.right != null) {
			if (node.val == node.right.val - 1) {
				helper(node.right, localMax + 1);
			}
			else {
				maxVal = Math.max(maxVal, localMax);
				helper(node.right, 1);
			}
		} 
		
		// leaf, right & left == null
		maxVal = Math.max(maxVal, localMax);
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