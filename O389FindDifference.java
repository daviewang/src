public class O389FindDifference {
	public char findTheDifference(String s, String t) {
		// use array
		/*
		int[] cArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cArray[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			cArray[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (cArray[i] == -1) {
				return (char)('a' + i);
			}
		}
		return 'a';
		*/
		
		// bits
		char res = 0;
		for (int i = 0; i < s.length(); i++) {
			res ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			res ^= t.charAt(i);
		}
		return res;
	}
}