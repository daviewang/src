public class O161OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		
		if (Math.abs(sLen - tLen) > 1) return false;
		
		if (sLen == tLen) {
			return sameSize(s, t);
		}
		
		if (sLen > tLen) {
			return oneDistance(s, t);
		}
		else {
			return oneDistance(t, s);
		}
	}
	
	private boolean sameSize(String s, String t) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}
	
	private boolean oneDistance(String s, String t) {
		for (int i = 0; i < s.length() - 1; i++) {			
			if (s.charAt(i) != t.charAt(i)) {
				if (s.charAt(i + 1) != t.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}