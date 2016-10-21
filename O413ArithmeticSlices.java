public class O413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
		int res = 0;
        if (A == null || A.length <= 2) return res;
		int[] dp = new int[A.length];
		
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				res += dp[i];
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		O413ArithmeticSlices e = new O413ArithmeticSlices();
		int[] A = {1, 2, 3, 4};
		e.numberOfArithmeticSlices(A);
	}
}