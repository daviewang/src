public class O075SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int firstPoint = 0;
		int lastPoint = nums.length - 1;
		int moverPoint = 0;
		
		while (moverPoint <= lastPoint) {
			if (nums[moverPoint] == 0) {
				nums[moverPoint] = nums[firstPoint];
				nums[firstPoint] = 0;
				firstPoint++;
				moverPoint++;
			}
			else if (nums[moverPoint] == 2) {
				nums[moverPoint] = nums[lastPoint];
				nums[lastPoint] = 2;
				lastPoint--;
			}
			else {
				moverPoint++;
			}
		}
	}
	public static void main(String[] args) {
		O075SortColors e = new O075SortColors();
		int[] in = {1, 0};
		e.sortColors(in);
	}
}