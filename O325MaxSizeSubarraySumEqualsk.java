import java.util.Map;
import java.util.HashMap;

public class O325MaxSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				res = i + 1;
			}
			else if (map.containsKey(sum - k)) {
				res = Math.max(res, i - map.get(sum - k));
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		O325MaxSizeSubarraySumEqualsk e = new O325MaxSizeSubarraySumEqualsk();
		int[] in = {1, -1, 5, -2, 3};
		e.maxSubArrayLen(in, 3);
	}
}