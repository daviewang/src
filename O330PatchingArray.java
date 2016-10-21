import java.util.*;
public class O330PatchingArray {
	public int minPatches(int[] nums, int n) {
		long missing = 1;
		int res = 0;
		int i = 0;
		List<Integer> resArray = new ArrayList<>();
		while (missing <= n) {
			if (i < nums.length && nums[i] <= missing) {
				missing += nums[i];
				i++;
			}
			else {
				resArray.add((int)missing);
				missing += missing;
				res++; 
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O330PatchingArray e = new O330PatchingArray();
		int[] nums = {2};
		System.out.println(e.minPatches(nums, 8));
	}
}