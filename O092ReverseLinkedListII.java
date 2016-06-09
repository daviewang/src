public class O092ReverseLinkedListII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x; }
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode firstNode = dummy;
		ListNode secondNode = dummy;
		int delta = n - m;
		
		while(m - 1 > 0) {
			firstNode = firstNode.next;
			m--;
		}
		
		while(n > 0) {
			secondNode = secondNode.next;
			n--;
		}
		
		while (delta-- > 0) {
			ListNode moveNode = firstNode.next;
			firstNode.next = moveNode.next;
			moveNode.next = secondNode.next;
			secondNode.next = moveNode;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O092ReverseLinkedListII e = new O092ReverseLinkedListII();
		ListNode l1 = e.new ListNode(1);
		ListNode l2 = e.new ListNode(2);
		ListNode l3 = e.new ListNode(3);
		ListNode l4 = e.new ListNode(4);
		ListNode l5 = e.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = null;
		e.reverseBetween(l1, 2, 4);
	}
}