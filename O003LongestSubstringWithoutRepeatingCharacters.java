import java.util.HashSet;
import java.util.Set;

public class O003LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Set<Character> set = new HashSet<>();
		int left = 0, right = 0;
		int res = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				res = Math.max(res, right - left);
				while(s.charAt(left) != c) {
					set.remove(s.charAt(left));
					left++;
				}
				left++;
			}
			else {
				set.add(c);
			}
			right++;
		}
		return Math.max(res, right - left);
	}
	public static void main(String[] args) {
		O003LongestSubstringWithoutRepeatingCharacters e = new O003LongestSubstringWithoutRepeatingCharacters();
		System.out.println(e.lengthOfLongestSubstring("abcabcbb"));
	}
}