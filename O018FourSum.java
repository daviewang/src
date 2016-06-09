import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O018FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			List<List<Integer>> threeSumList = threeSum(nums, i + 1, target - nums[i]);
			if (threeSumList != null) {
				for (List<Integer> threeSumItem : threeSumList) {
					threeSumItem.add(0, nums[i]);
					res.add(new ArrayList<>(threeSumItem));
				}
			}
			while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
		}
		return res;
	}
	private List<List<Integer>> threeSum(int[] nums, int start, int target) {
		List<List<Integer>> res = new ArrayList<>();
		while (start < nums.length - 2) {
			int first = nums[start];
			int begin = start + 1;
			int end = nums.length - 1;
			while (begin < end && begin < nums.length - 1) {
				if (first == target - nums[begin] - nums[end]) {
					List<Integer> singleRes = new ArrayList<>();
					singleRes.add(first);
					singleRes.add(nums[begin]);
					singleRes.add(nums[end]);
					res.add(singleRes);
					while (begin < nums.length - 2 && nums[begin] == nums[begin + 1]) begin++;
					while (begin < end && nums[end] == nums[end - 1]) end--;
					begin++;
					end--;
				}
				else if (first < target - nums[begin] - nums[end]) {
					while (begin < nums.length - 2 && nums[begin] == nums[begin + 1]) begin++;
					begin++;
				}
				else {
					while (begin < end && nums[end] == nums[end - 1]) end--;
					end--;
				}
			}
			while(start < nums.length -2 && nums[start] == nums[start + 1]) start++;
			start++;
		}
		return res;
	}
	public static void main(String[] args) {
		O018FourSum e = new O018FourSum();
		int[] in = {-3,0,0,1,2,3};
		e.fourSum(in, 0);
	}
}