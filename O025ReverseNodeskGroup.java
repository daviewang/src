public class O025ReverseNodeskGroup {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 0 || k == 1) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		int i = 1;
		while(head != null){
			head = head.next;
			if (i++ % k == 0) {
				pre = reverseHelper(pre, head);
				head = pre.next;
			}
		}
		return dummy.next;
	}
	/*
    * 0->1->2->3->4->5->6
    * |           |   
    * pre       end
    */
	private ListNode reverseHelper(ListNode pre, ListNode end) {
		ListNode curr = pre.next;
		while (curr.next != end) {
			ListNode node = curr.next;
			curr.next = curr.next.next;
			node.next = pre.next;
			pre.next = node;
		}
		pre = curr;
		return pre;
	}
	
	public static void main(String[] args) {
		O025ReverseNodeskGroup e = new O025ReverseNodeskGroup();
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
		
		e.reverseKGroup(l1, 3);
	}
}