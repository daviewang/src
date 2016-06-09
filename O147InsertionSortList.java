public class O147InsertionSortList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		
		while (head != null) {
			ListNode node = head;
			head = head.next;
			node.next = null;
			
			ListNode pre = dummy;
			if (pre.next == null) {
				pre.next = node;
			}
			else {
				while (pre.next != null && node.val > pre.next.val) {
					pre = pre.next;
				}
				node.next = pre.next;
				pre.next = node;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O147InsertionSortList e = new O147InsertionSortList();
		ListNode l1 = e.new ListNode(1);
		ListNode l2 = e.new ListNode(3);
		ListNode l3 = e.new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		e.insertionSortList(l1);
	}
}