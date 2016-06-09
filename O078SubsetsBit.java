import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O078SubsetsBit {
	public List<List<Integer>> subsets(int[]nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		int max = 1 << nums.length;
		for (int i = 0; i < max; i++) {
			List<Integer> singlRes = convertIntToSet(nums, i);
			res.add(singlRes);
		}
		return res;
	}
	private List<Integer> convertIntToSet(int[] nums, int val) {
		List<Integer> res = new ArrayList<>();
		int idx = 0;
		for (int i = val; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				res.add(nums[idx]);
			}
			idx++;
		}
		return res;
	}
	public static void main(String[] args) {
		O078SubsetsBit e = new O078SubsetsBit();
		int[] in = {1, 2};
		e.subsets(in);
	}
}