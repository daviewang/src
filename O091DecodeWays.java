public class O091DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length() + 1];
		//10
		dp[0] = 1;
		if (s.charAt(0) == '0') {
			dp[1] = 0;
		}
		else {
			dp[1] = 1;
		}
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) {
				dp[i] = dp[i - 1];
			}
			if (isValid(s.substring(i - 2, i))) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
	private boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return false;
		}
		int val = Integer.valueOf(s);
		if (val >= 1 && val <= 26) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		O091DecodeWays e = new O091DecodeWays();
		System.out.println(e.numDecodings("10"));
	}
}