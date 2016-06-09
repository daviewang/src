public class O117PopulatingNextRightPointersII {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {val = x;}
	}
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode head = new TreeLinkNode(0);
		
		while (root != null) {
			TreeLinkNode curr = head;
			while (root != null) {
				if (root.left != null) {
					curr.next = root.left;
					curr = curr.next;
				}
				if (root.right != null) {
					curr.next = root.right;
					curr = curr.next;
				}
				root = root.next;
			}
			root = head.next;
			head.next = null;
		}	
	}
}