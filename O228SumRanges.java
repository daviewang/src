import java.util.ArrayList;
import java.util.List;

public class O228SumRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		int beginIdx = 0;
		int endIdx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[endIdx] + 1 == nums[i]) {
				endIdx++;
			}
			else {
				res.add(generateRange(nums, beginIdx, endIdx));
				beginIdx = i;
				endIdx = i;
			}
		}
		res.add(generateRange(nums, beginIdx, endIdx));
		return res;
	}
	private String generateRange(int[] nums, int beginIdx, int endIdx) {
		StringBuilder sb = new StringBuilder();
		if (beginIdx == endIdx) {
			sb.append(nums[beginIdx]);
		}
		else {
			sb.append(nums[beginIdx] + "->" + nums[endIdx]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		O228SumRanges e = new O228SumRanges();
		int[] in = {0};
		e.summaryRanges(in);
	}
}