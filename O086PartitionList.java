public class O086PartitionList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyL = new ListNode(0);
		ListNode dummyS = new ListNode(0);
		ListNode headL = dummyL;
		ListNode headS = dummyS;
		
		while (head != null) {
			if (head.val < x) {
				headS.next = head;
				headS = headS.next;
				head = head.next;
				headS.next = null;
			}
			else {
				headL.next = head;
				headL = headL.next;
				head = head.next;
				headL.next = null;
			}
		}
		headS.next = dummyL.next;
		return dummyS.next;
	}
}