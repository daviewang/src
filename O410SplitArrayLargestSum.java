public class O410SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return 0;
		long left = Integer.MIN_VALUE;
		long right = 0;
		for (int num : nums) {
			right += num;
			left = Math.max(left, num);
		}
		
		while (left < right) {
			long mid = left + (right - left) / 2;
			if (valid(nums, m, mid)) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return (int)right;
    }
    
    private boolean valid(int[] nums, int m, long range) {
		int count = 0;
		int maxRange = 0;
		for (int num : nums) {
			if (maxRange + num > range) {
				maxRange = num;
				count++;
				if (count >= m) return false;
			}
			else {
				maxRange += num;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
    	O410SplitArrayLargestSum e = new O410SplitArrayLargestSum();
    	int[] in = {7,2,5,10,7};
    	e.splitArray(in, 2);
    }
}
