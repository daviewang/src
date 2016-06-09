public class O143ReorderList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		ListNode fastH = head;
		ListNode slowH = head;
		ListNode pre = null;
		while (fastH != null && fastH.next != null) {
			pre = slowH;
			slowH = slowH.next;
			fastH = fastH.next.next;
		}
		pre.next = null;
		
		ListNode secondH = reverseList(slowH);
		mergeList(head, secondH);
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		while(head.next != null) {
			ListNode node = head.next;
			head.next = head.next.next;			
			node.next = dummy.next;
			dummy.next = node;
		}
		return dummy.next;
	}
	
	private ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1 != null) {
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			}
			if (l2 != null) {
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			curr.next = l2;
		}
		else {
			curr.next = l1;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O143ReorderList e = new O143ReorderList();
		ListNode l1 = e.new ListNode(1);
		ListNode l2 = e.new ListNode(2);
		ListNode l3 = e.new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		e.reorderList(l1);
	}
}