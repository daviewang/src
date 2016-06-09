public class O214ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		int end = j;
		char[] cArray = s.toCharArray();
		
		while (i < j) {
			if (cArray[i] == cArray[j]) {
				i++;
				j--;
			}
			else {
				i = 0;
				end--;
				j = end;
			}
		}
		//return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
		StringBuilder sb = new StringBuilder(s.substring(end + 1));
		sb.reverse();
		sb.append(s);
		return sb.toString();
	}
	public static void main(String[] args) {
		O214ShortestPalindrome e = new O214ShortestPalindrome();
		e.shortestPalindrome("abcd");
	}
}