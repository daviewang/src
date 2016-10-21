import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O368LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		int[] counts = new int[nums.length];
		int[] parents = new int[nums.length];
		int max = 0;
		int maxID = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % nums[i] == 0 && counts[i] < counts[j] + 1) {
					counts[i] = counts[j] + 1;
					parents[i] = j;
					if (max < counts[i]) {
						max = counts[i];
						maxID = i;
					}
				}
			}
		}
		while (max-- > 0) {
			res.add(nums[maxID]);
			maxID = parents[maxID];
		}
		return res;
	}
	public static void main(String[] args) {
		O368LargestDivisibleSubset e = new O368LargestDivisibleSubset();
		int[] nums = {2, 4, 8};
		e.largestDivisibleSubset(nums);
	}
}