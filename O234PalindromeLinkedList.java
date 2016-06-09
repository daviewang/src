import java.util.Stack;

public class O234PalindromeLinkedList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			int top = stack.pop();
			if (top != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}