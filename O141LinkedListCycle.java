public class O141LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x; }
	}
	public boolean hascycle(ListNode head) {
		if (head == null) return false;
		ListNode fastH = head;
		ListNode slowH = head;
		
		while(fastH != null && fastH.next != null) {
			slowH = slowH.next;
			if (fastH.next == null) return false;
			fastH = fastH.next.next;
			if (slowH == fastH) return true;
		}
		return false;
	}
}