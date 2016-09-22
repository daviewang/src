import java.util.Random;

public class O382LinkedListRandomNode {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	ListNode head;
	Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public O382LinkedListRandomNode(ListNode head) {
       this.head = head;
       this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null;
        ListNode curr = head;
        
        for (int i = 0; curr != null; i++) {
        	if (random.nextInt(i + 1) == 0) { //Ìæ»»
        		res = curr;
        	}
        	curr = curr.next;
        }
        return res.val;
    }
}