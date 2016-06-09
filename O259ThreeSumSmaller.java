import java.util.Arrays;

public class O259ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1; 
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum < target) {
					res += right - left;
					left++;
				}
				else {
					right--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O259ThreeSumSmaller e = new O259ThreeSumSmaller();
		int[] in = {-2, 0, 1, 3};
		System.out.println(e.threeSumSmaller(in, 2));
	}
}