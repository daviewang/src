public class O002AddTwoNumbers {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(l1 != null || l2 != null || carry != 0) {
			int a = l1 == null ? 0 : l1.val;
			int b = l2 == null ? 0 : l2.val;
			ListNode node = new ListNode((a + b + carry) % 10);
			carry = (a + b + carry) / 10;
			head.next = node;
			head = head.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		return dummy.next;
	}
}