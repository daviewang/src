public class O019RemoveNthNodeFromEnd {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0 || head == null) return head;
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		dummy.next = head;
		ListNode curr = pre.next;
		
		
		while(n-- > 0) {
			curr = curr.next;
		}
		
		while (curr != null) {
			curr = curr.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O019RemoveNthNodeFromEnd e = new O019RemoveNthNodeFromEnd();
		ListNode n1 = e.new ListNode(1);
		ListNode n2 = e.new ListNode(2);
		ListNode n3 = e.new ListNode(3);
		ListNode n4 = e.new ListNode(4);
		ListNode n5 = e.new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		e.removeNthFromEnd(n1, 2);
	}
}