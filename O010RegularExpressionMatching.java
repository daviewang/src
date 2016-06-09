public class O010RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		boolean[][] dp = new boolean[sLen + 1][pLen + 1];
		dp[0][0] = true;
		
		for (int i = 0; i < sLen; i++) {
			dp[i + 1][0] = false;
		}
		
		for (int i = 0; i < pLen; i++) {
			dp[0][i + 1] = p.charAt(i) == '*' && i >= 1 && dp[0][i - 1];
		}
		
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (p.charAt(j - 1) != '*') {
					dp[i][j] = dp[i - 1][j - 1] &&
						(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
				}
				else {
					dp[i][j] = dp[i][j - 1] ||
							   (j > 1 && dp[i][j - 2]) ||
							   dp[i - 1][j] && j > 1 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1));
							   //"abccccc" "abc*" (true); "abccccc" "ab*" (false)
				}
			}
		}
		return dp[sLen][pLen];
	}
}