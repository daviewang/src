public class O044WildcardMatching {
	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		boolean[][] dp = new boolean[sLen + 1][pLen + 1];
		dp[0][0] = true;
		
		for (int i = 0; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				char c = p.charAt(j - 1);
				if (c != '*') {
					dp[i][j] = i > 0 && dp[i - 1][j - 1] &&
							   (c == s.charAt(i - 1) || c == '?');
				}
				else {
					for (int k = i; k >= 0; k--) {
						if (dp[k][j - 1] == true) {
							dp[i][j] = true;
							break;
						}
					}
					if (j == 1) dp[i][j] = true; // i 要从0开始， ""; "*"
				}
			}
		}
		return dp[sLen][pLen];
	}
}