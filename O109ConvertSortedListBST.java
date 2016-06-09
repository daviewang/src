public class O109ConvertSortedListBST {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {val = x; }
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = null;
		
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (pre != null) pre.next = null;
		
		TreeNode tNode = new TreeNode(slow.val);
		if (slow == head) {
			tNode.left = null;
			tNode.right = null;
			return tNode;
		}
		ListNode rightHead = slow.next;
		slow.next = null;
		tNode.left = sortedListToBST(head);
		tNode.right = sortedListToBST(rightHead);
		return tNode;
	}
	
	public static void main(String[] args) {
		
	}
}