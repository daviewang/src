public class O189RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <2 || k <= 0) return;
		int len = nums.length;
		
		reverse(nums, 0, len - 1);
		reverse(nums, 0, k % len - 1);
		reverse(nums, k % len, len - 1);
	}
	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		O189RotateArray e = new O189RotateArray();
		int[] nums = {1,2,3,4,5,6,7};
		e.rotate(nums, 3);
	}
}