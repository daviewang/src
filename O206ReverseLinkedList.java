public class O206ReverseLinkedList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x){val = x;}
	}
	public ListNode reverseList(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		
		ListNode curr = head;
		while (curr != null) {
			ListNode node = curr;
			curr = curr.next;			
			node.next = dummy.next;
			dummy.next = node;
		}
		
		return dummy.next;
	}
}