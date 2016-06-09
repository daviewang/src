public class O108ConvertSortedArrayBST {
	class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		O108ConvertSortedArrayBST e = new O108ConvertSortedArrayBST();
		int[] in = {0};
		e.sortedArrayToBST(in);
	}
}