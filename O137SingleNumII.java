public class O137SingleNumII {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (getBit(nums[j], i) == 1) {
					count++;
				}
			}
			if (count % 3 == 1) {
				res |= (1 << i);
			}
		}
		return res;
	}
	
	private int getBit(int num, int pos) {
		if ((num & (1 << pos)) != 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		O137SingleNumII e = new O137SingleNumII();
		int[] in = {1};
		e.singleNumber(in);
	}
}