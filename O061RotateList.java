public class O061RotateList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode rotateRight(ListNode head, int k){
		if (head == null || k == 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		int len = 1;
		while (fast.next != null) {
			fast = fast.next;
			len++;
		}
		
		int stepsOfSlow = len - k % len;
		while (stepsOfSlow-- > 1) {
			slow = slow.next;
		}
			
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		O061RotateList e = new O061RotateList();
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
		e.rotateRight(l1, 2);
	}
}