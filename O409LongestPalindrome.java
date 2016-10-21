public class O409LongestPalindrome {
	public int longestPalindrome(String s) {
		int res = 0;
		int mid = 0;
		if (s == null || s.length() == 0) return res;
		int[] charsCount = new int[52];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int charRange = c - 'a';
			if (charRange < 26 && charRange >= 0) {
				charsCount[charRange]++;
			}
			else {
				charsCount[26 + c - 'A']++;
			}
		}
		
		for (int i = 0; i < 52; i++) {
			if (charsCount[i] % 2 == 0) {
				res += charsCount[i];
			}
			else {
				res += charsCount[i] - 1;
				mid = 1;
			}
		}
		return res + mid;
	}
	
	public static void main(String[] args) {
		O409LongestPalindrome e = new O409LongestPalindrome();
		e.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
	}
}