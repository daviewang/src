public class O031NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		int i = nums.length - 1;
		for (; i >= 1; i--) {
			if (nums[i - 1] < nums[i]) {
				swap(nums, i - 1);
				break;
			}
		}
		reverse(nums, i);
	}
	
	private void swap(int[] nums, int idx) {
		for (int i = nums.length - 1; i > idx; i--) {
			if (nums[idx] < nums[i]) {
				int temp = nums[i];
				nums[i] = nums[idx];
				nums[idx] = temp;
				break;
			}
		}
	}
	
	private void reverse(int[] nums, int idx) {
		int head = idx;
		int end = nums.length - 1;
		while (head < end) {
			int temp = nums[head];
			nums[head] = nums[end];
			nums[end] = temp;
			head++;
			end--;
		}
	}
	public static void main(String[] args) {
		O031NextPermutation e = new O031NextPermutation();
		int[] in = {1, 3, 2};
		e.nextPermutation(in);
	}
}