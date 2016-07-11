public class O369PlusOneLinkedList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode plusOne(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode firstTail = dummy;
		ListNode secondTail = dummy;
		
		while (secondTail.next != null) {
			secondTail = secondTail.next;
			if (secondTail.val != 9) {
				firstTail = secondTail;
			}
		}
		if (secondTail.val != 9) {
			secondTail.val++;
		}
		else {
			firstTail.val++;
			while (firstTail.next != null) {
				firstTail = firstTail.next;
				firstTail.val = 0;
			}
		}
		if (dummy.val == 1) {
			return dummy;
		}
		else {
			return dummy.next;
		}
	}
	public static void main(String[] args) {
		O369PlusOneLinkedList e = new O369PlusOneLinkedList();
		ListNode l1 = e.new ListNode(9);
		ListNode l2 = e.new ListNode(9);
		ListNode l3 = e.new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		e.plusOne(l1);
	}
}
			