public class O083RemoveDupSortedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode slowHead = head;
		ListNode fastHead = head;
		int cacheVal = head.val;
		
		while (fastHead != null) {
			if (cacheVal == fastHead.val) {
				fastHead = fastHead.next;
			}
			else {
				slowHead.next = fastHead;
				cacheVal = fastHead.val;
				slowHead = slowHead.next;
			}
		}
		slowHead.next = null;
		return dummy.next;
	}
}