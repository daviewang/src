public class O383RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] charsNum = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			charsNum[magazine.charAt(i) - 'a']++;
		}
        for (int i = 0; i < ransomNote.length(); i++) {
        	if (--charsNum[ransomNote.charAt(i) - 'a'] < 0)
        		return false;
        }
        return true;
    }
}