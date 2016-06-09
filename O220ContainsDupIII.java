import java.util.TreeSet;

public class O220ContainsDupIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0) return false;
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long n = nums[i];
			if ((set.floor(n) != null && Math.abs(n - set.floor(n)) <= t) ||
				(set.ceiling(n) != null && Math.abs(n - set.ceiling(n)) <= t))
				return true;
			set.add(n);
			if (i >= k) {
				set.remove((long)nums[i - k]);
			}
		}
		return false;
	}
}