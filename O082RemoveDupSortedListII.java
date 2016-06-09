public class O082RemoveDupSortedListII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode curr = head;
		ListNode pre = dummy;
		boolean dup;
		
		while (curr != null) {
			dup = false;
			while (curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
				dup = true;
			}
			if (dup) {
				curr = curr.next;
				continue;
			}
			pre.next = curr;
			pre = pre.next;
			curr = curr.next;
		}
		pre.next = null;
		return dummy.next;
	}
}