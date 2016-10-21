import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O315CountSmallerNumsAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) return new ArrayList<>();
		Integer[] res = new Integer[nums.length];
		List<Integer> sorted = new ArrayList<>();
		
		for (int i = nums.length - 1; i >= 0; i--) {
			int idx = findIndex(sorted, nums[i]);
			res[i] = idx;
			sorted.add(idx, nums[i]);
		}
		return Arrays.asList(res);
	}
	
	private int findIndex(List<Integer> sorted, int val) {
		if (sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size() - 1;
		if (val < sorted.get(start)) return 0;
		if (sorted.get(end) < val) return sorted.size();
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (sorted.get(mid) < val) {
				start = mid + 1;
			}
			else if (sorted.get(mid) > val) {
				end = mid - 1;
			}
			else {
			    return mid;
			}
		}
		return end;
	}
	
	public static void main(String[] args) {
		O315CountSmallerNumsAfterSelf e = new O315CountSmallerNumsAfterSelf();
		int[] in = {5,2,6,1};
		e.countSmaller(in);
	}
}