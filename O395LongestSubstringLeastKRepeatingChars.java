public class O395LongestSubstringLeastKRepeatingChars {
	public int longestSubstring(String s, int k) {
	      char[] str = s.toCharArray();
		  return helper(str, 0, s.length(), k);
	    }
	private int helper(char[] str, int start, int end, int k) {
		if (end < start) return 0;
		if (end - start < k) return 0;
		int[] count = new int[26];
		for (int i = start; i < end; i++) {
			count[str[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0) continue;
			if (count[i] < k) {
				for (int j = start; j < end; j++) {
					if (str[j] == i + 'a') {
						int left = helper(str, start, j, k);
						int right = helper(str, j + 1, end, k);
						return Math.max(left, right);
					}
				}
			}
		}
		return end - start;
	}
}