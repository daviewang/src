public class O132PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int[] res = new int[len];
		boolean[][] isPalindrome = new boolean[len][len];
		
		for (int start = len - 1; start >= 0; start--) {
			res[start] = len - 1 - start;
			for (int end = start; end < len; end++) {
				if (s.charAt(start) == s.charAt(end)) {
					if (end - start < 2) {
						isPalindrome[start][end] = true;
					}
					else {
						isPalindrome[start][end] = isPalindrome[start + 1][end - 1];
					}
				}
				if (isPalindrome[start][end]) {
					if (end == len - 1) {
						res[start] = 0;
					}
					else {
						res[start] = Math.min(res[start], 1 + res[end + 1]);
					}
				}
			}
		}
		return res[0];
	}
}