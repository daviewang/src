public class O328OddEvenLinkedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyOdd = new ListNode(0);
		dummyOdd.next = head;
		ListNode dummyEven = new ListNode(0);
		dummyEven.next = head.next;
		
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		
		while(evenHead.next != null) {
			if (oddHead.next.next != null) {
				oddHead.next = oddHead.next.next;
				oddHead = oddHead.next;
			}
			else {
				oddHead.next = null;
			}
			if (evenHead.next.next != null) {
				evenHead.next = evenHead.next.next;
				evenHead = evenHead.next;
			}
			else {
				evenHead.next = null;
			}
		}
		oddHead.next = dummyEven.next;
		evenHead.next = null;
		return dummyOdd.next;
	}
}