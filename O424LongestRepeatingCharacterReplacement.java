public class O424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
			return 0;
		}
		int[] charsNum = new int[26];
		int start = 0; 
		int end = 0;
		int maxCount = 0;
		int res = 0;
		
		for (; end < s.length(); end++) {
			charsNum[s.charAt(end) - 'A']++;
			maxCount = Math.max(maxCount, charsNum[s.charAt(end) - 'A']);
			
			while (end - start + 1 - maxCount > k) {
				charsNum[s.charAt(start) - 'A']--;
				start++;
				for (int i = 0; i < 26; i++) {
					maxCount = Math.max(maxCount, charsNum[i]);
				}
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
    }
    
    public static void main(String[] args) {
    	O424LongestRepeatingCharacterReplacement e = new O424LongestRepeatingCharacterReplacement();
    	e.characterReplacement("AABAB", 1);
    }
}