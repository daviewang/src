public class O416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		
		if (sum % 2 == 1) {
			return false;
		}
		
		sum /= 2;
		
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > sum) {
				return false;
			}
			for (int j = sum; nums[i] <= j; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[sum];
    }
    
    public static void main(String[] args) {
    	O416PartitionEqualSubsetSum e = new O416PartitionEqualSubsetSum();
    	int[] in = {1, 2, 3, 5};
    	System.out.println(e.canPartition(in));
    }
}