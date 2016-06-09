import java.util.ArrayDeque;
import java.util.Deque;

public class O239SlidingWinMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		int resIdx = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.offer(i);
			if (i >= k - 1) {
				res[resIdx++] = nums[deque.peek()];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O239SlidingWinMax e = new O239SlidingWinMax();
		int[] nums= {7, 2, 4};
		e.maxSlidingWindow(nums, 2);
	}
}
 