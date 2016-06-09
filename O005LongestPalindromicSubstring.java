public class O005LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return s;
		}
		String res = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			String temp = getPalindrome(s, i, i);
			if (temp.length() > res.length()) {
				res = temp;
			}
			temp = getPalindrome(s, i, i + 1);
			if (temp.length() > res.length()) {
				res = temp;
			}
		}
		return res;
	}
	
	private String getPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return s.substring(i + 1, j);
	}
}