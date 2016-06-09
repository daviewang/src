public class O021MergeTwoSortedLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode mergeHead = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				mergeHead.next = l1;
				l1 = l1.next;
				mergeHead = mergeHead.next;
			}
			else {
				mergeHead.next = l2;
				l2 = l2.next;
				mergeHead = mergeHead.next;
			}
		}
		if (l1 == null) {
			mergeHead.next = l2;
		}
		else {
			mergeHead.next = l1;
		}
		return dummy.next;
	}
}