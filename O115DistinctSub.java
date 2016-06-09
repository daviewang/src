public class O115DistinctSub {
	public int numDistinct(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		
		int[][] res = new int[sLen + 1][tLen + 1];
		res[0][0] = 1;
		
		for (int i = 1; i <= sLen; i++) {
			res[i][0] = 1;
		}
		
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= tLen; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
				}
				else {
					res[i][j] = res[i - 1][j];
				}
			}
		}
		return res[sLen][tLen];
	}
}