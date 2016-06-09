public class O307RangeSumQueryMutable {
	class SegmentNode {
		int val, start, end;
		SegmentNode left, right;
		public SegmentNode(int start, int end) {
			this.start = start;
			this.end = end;
			left = null;
			right = null;
		}
	}
	
	SegmentNode root;
	
	public O307RangeSumQueryMutable(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}
	
	private SegmentNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			SegmentNode node = new SegmentNode(start, end);
			node.val = nums[start];
			return node;
		}
		int mid = start + (end - start) / 2;
		SegmentNode node = new SegmentNode(start, end);
		node.left = buildTree(nums, start, mid);
		node.right = buildTree(nums, mid + 1, end);
		node.val = node.left.val + node.right.val;
		return node;
	}
	
	public void update(int i, int val) {
		update(root, i, val);
	}
	
	private void update(SegmentNode root, int pos, int val) {
		if (root.start == root.end) {
			root.val = val;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (pos <= mid) {
			update(root.left, pos, val);
		}
		else {
			update(root.right, pos, val);
		}
		root.val = root.left.val + root.right.val;
	}
	
	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}
	
	private int sumRange(SegmentNode root, int left, int right) {
		if (root.start == left && root.end == right) {
			return root.val;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (right <= mid) {
			return sumRange(root.left, left, right);
		}
		else if (left > mid) {
			return sumRange(root.right, left, right);
		}
		return sumRange(root, left, mid) + sumRange(root, mid + 1, right);
	}
}