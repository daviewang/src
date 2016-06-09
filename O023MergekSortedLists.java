import java.util.Comparator;
import java.util.PriorityQueue;

public class O023MergekSortedLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(10, 
			new Comparator<ListNode>() {
				public int compare(ListNode l1, ListNode l2) {
					return l1.val - l2.val;
				}
			}
		);
		for (ListNode node : lists) {
			if (node != null)
				pq.add(node);
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			head.next = node;
			head = head.next;
			node = node.next;
			if (node != null)
				pq.add(node);
		}
		return dummy.next;
	}
}