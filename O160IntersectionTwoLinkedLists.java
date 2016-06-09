public class O160IntersectionTwoLinkedLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode currA = headA;
		ListNode currB = headB;
		int lenA = 0;
		int lenB = 0;
		
		while (currA != null) {
			lenA++;
			currA = currA.next;
		}
		
		while (currB != null) {
			lenB++;
			currB = currB.next;
		}
		
		
		if (lenA < lenB) {
			int delta = lenB - lenA;
			while(delta-- > 0) {
				headB = headB.next;
			}
		}
		else {
			int delta = lenA - lenB;
			while(delta-- > 0) {
				headA = headA.next;
			}
		}
		
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
}