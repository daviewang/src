import java.util.Arrays;

public class O324WiggleSortII {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[len - 1 - i];
			nums[len - 1 - i] = temp;
		}
		int midIdx = len / 2;
		
		int[] bigHalf = new int[midIdx];
		int[] smallHalf = new int[len - midIdx];
		
		for (int i = 0; i < midIdx; i++) {
			bigHalf[i] = nums[i];
		}
		
		for (int i = midIdx; i <= len - 1; i++) {
			smallHalf[i - midIdx] = nums[i];
		}
		
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				nums[i] = smallHalf[i / 2];
			}
			else {
				nums[i] = bigHalf[i / 2];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] in = {1,5,1,1,6,4};
		O324WiggleSortII e = new O324WiggleSortII();
		e.wiggleSort(in);
	}
}