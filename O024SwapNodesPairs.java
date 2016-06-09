public class O024SwapNodesPairs {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) 
			return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode first = head;
		ListNode second = head.next;
		
		while(first != null && second != null) {
			pre.next = second;
			first.next = second.next;
			second.next = first;
			
			pre = first;
			first = first.next;
			if (first != null) {
				second = first.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O024SwapNodesPairs e = new O024SwapNodesPairs();
		ListNode l1 = e.new ListNode(1);
		ListNode l2 = e.new ListNode(2);
		ListNode l3 = e.new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		e.swapPairs(l1);
	}
}