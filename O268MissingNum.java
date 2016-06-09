public class O268MissingNum {
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
			res ^= i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		O268MissingNum e = new O268MissingNum();
		int[] in = {0, 1, 2, 3, 4, 6};
		e.missingNumber(in);
	}
}