public class O142LinkedListCycleII {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fastH = head;
		ListNode slowH = head;
		ListNode newH = null;
		
		while (fastH != null && fastH.next != null) {
			slowH = slowH.next;
			if (fastH.next == null) return null;
			fastH = fastH.next.next;
			if (fastH == slowH) {
				newH = fastH;
				break;
			}
		}
		if (newH == null) return newH;
		
		slowH = head;
		while (slowH != newH) {
			slowH = slowH.next;
			newH = newH.next;
		}
		return newH;
	}
	public static void main(String[] args) {
		O142LinkedListCycleII e = new O142LinkedListCycleII();
		ListNode n1 = e.new ListNode(1);
		ListNode n2 = e.new ListNode(2);
		n1.next = n2;
		n2.next = null;
		e.detectCycle(n1);
	}
}