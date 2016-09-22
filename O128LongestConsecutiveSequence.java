import java.util.HashMap;
import java.util.Map;

public class O128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Boolean> isVisited = new HashMap<>();
		for (Integer num : nums) {
			isVisited.put(num, false);
		}
		int res = Integer.MIN_VALUE;
		for (Integer num : nums) {
			int singleRes = 1;
			int nextNum = num + 1;		
			isVisited.put(num, true);
			while (isVisited.containsKey(nextNum) && !isVisited.get(nextNum)) {
				isVisited.put(nextNum, true);
				singleRes++;
				nextNum++;
			}
			nextNum = num - 1;
			while (isVisited.containsKey(nextNum) && !isVisited.get(nextNum)) {
				isVisited.put(nextNum, true);
				singleRes++;
				nextNum--;
			}
			res = Math.max(res, singleRes);
		}
		return res;
	}
	
	public static void main(String[] args) {
		O128LongestConsecutiveSequence e = new O128LongestConsecutiveSequence();
		int[] in = {1, 2, 3};
		System.out.println(e.longestConsecutive(in));
	}
}