public class O280WiggleSort {
	public void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 ==1 && nums[i - 1] > nums[i]) {
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
			if (i % 2 == 0 && nums[i] > nums[i - 1]) {
				int temp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = temp;
			}
		}
	}	
	
	public static void main(String[] args) {
		O280WiggleSort e = new O280WiggleSort();
		int[] in = {3, 5, 2, 1, 6, 4};
		e.wiggleSort(in);
		System.out.println("test");
	}
}