import java.util.HashSet;
import java.util.Set;

public class  O266PalindromePermutation {
	public boolean canPalindromePermutation(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
			}
			else {
				set.add(c);
			}
		}
		return set.size() == 0 || set.size() == 1;
	}
	
	public static void main(String[] args) {
		O266PalindromePermutation e = new O266PalindromePermutation();
		System.out.println(e.canPalindromePermutation("code"));
	}
}