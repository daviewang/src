public class O316RemoveDupLetters {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < s.charAt(pos)) pos = i;
			
			int j = --alphabet[c - 'a'];
			if (j == 0) break;
			
		}
			return s.length() == 0 ? "" : s.charAt(pos) + 
				removeDuplicateLetters(s.substring(pos + 1).replaceAll(Character.toString(s.charAt(pos)), ""));
	}
	//"eeaaaabcde"
	//"eeaaaabcd"
	public static void main(String[] args) {
		O316RemoveDupLetters e = new O316RemoveDupLetters();
		e.removeDuplicateLetters("eeaaaabcd");
	}
}