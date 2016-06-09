public class O138CopyListRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		
		// generate the new node
		RandomListNode cursor = head;
		while(cursor != null) {
			RandomListNode newNode = new RandomListNode(cursor.label);
			newNode.next = cursor.next;
			cursor.next = newNode;
			newNode.random = cursor.random;
			cursor = newNode.next;
		}
		
		// reset Random
		cursor = head;
		while (cursor != null) {
			if (cursor.random != null) {
				cursor.next.random = cursor.random.next;
			}
			cursor = cursor.next.next;
		}
		
		//detach the old and new
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode newCursor = dummy;
		RandomListNode oldCursor = head;
		while (oldCursor != null) {
			newCursor.next = oldCursor.next;
			oldCursor.next = newCursor.next.next;
			
			newCursor = newCursor.next;
			oldCursor = oldCursor.next;
		}
		return dummy.next;
	}
}