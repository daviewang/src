import java.util.HashMap;
import java.util.Map;

public class O219ContainsDupII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0) return false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
	public static void main(String[] args) {
		O219ContainsDupII e = new O219ContainsDupII();
		int[] nums = {1, 0, 1, 1};
		e.containsNearbyDuplicate(nums, 1);
	}
}