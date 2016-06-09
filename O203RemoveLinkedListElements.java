public class O203RemoveLinkedListElements {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		while (head != null) {
			if (head.val == val) {
				head = head.next;
				pre.next = head;
			}
			else {
				pre.next = head;
				pre = pre.next;
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O203RemoveLinkedListElements e = new O203RemoveLinkedListElements();
		ListNode l1 = e.new ListNode(1);
		ListNode l2 = e.new ListNode(2);
		ListNode l3 = e.new ListNode(6);
		ListNode l4 = e.new ListNode(3);
		ListNode l5 = e.new ListNode(4);
		ListNode l6 = e.new ListNode(5);
		ListNode l7 = e.new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = null;
		
		e.removeElements(l1, 6);
	}
}