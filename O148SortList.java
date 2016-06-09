public class O148SortList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode secondH = findMid(head);
		return merge(sortList(head), sortList(secondH));
	}
	
	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fastH = head;
		ListNode slowH = head;
		ListNode pre = null;
		while (fastH != null && fastH.next != null) {
			pre = slowH;
			slowH = slowH.next;
			fastH = fastH.next.next;
		}
		pre.next = null;
		return slowH;
	}
	
	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while (a != null && b != null) {
			if (a.val < b.val) {
				curr.next = a;
				a = a.next;
			}
			else {
				curr.next = b;
				b = b.next;
			}
			curr = curr.next;
		}
		if (a == null) {
			curr.next = b;
		}
		else {
			curr.next = a;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O148SortList e = new O148SortList();
		ListNode l1 = e.new ListNode(3);
		ListNode l2 = e.new ListNode(4);
		ListNode l3 = e.new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		e.sortList(l1);
	}
}