public class O125ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			char cBegin = s.charAt(begin);
			char cEnd = s.charAt(end);
			if (!Character.isLetterOrDigit(cBegin)) {
				begin++;
			}
			else if (!Character.isLetterOrDigit(cEnd)) {
				end--;
			}
			else if (Character.toLowerCase(cBegin) != Character.toLowerCase(cEnd)) {
				return false;
			}
			else {
				begin++;
				end--;
			}
		}
		return true;
	}
}