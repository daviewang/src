import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O015TreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int target = -nums[i];
			int begin = i + 1;
			int end = nums.length - 1;
			while (begin < end) {
				if (nums[begin] > target - nums[end]) {
					end--;
				}
				else if (nums[begin] < target - nums[end]) {
					begin++;
				}
				else {
					List<Integer> singleRes = new ArrayList<>();
					singleRes.add(nums[i]);
					singleRes.add(nums[begin]);
					singleRes.add(nums[end]);
					res.add(singleRes);
					while(begin < end && nums[begin] == singleRes.get(1)) begin++;
					while(begin < end && nums[end] == singleRes.get(2)) end--;
				}
			}
			while(i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) i++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] in = {-2, 0, 1, 1, 2};
		O015TreeSum e = new O015TreeSum();
		e.threeSum(in);
	}
}