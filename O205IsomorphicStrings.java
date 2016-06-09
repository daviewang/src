import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class O205IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) return false;
		if (s.length() != t.length()) return false;
		
		char sChar, tChar;
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			sChar = s.charAt(i);
			tChar = t.charAt(i);
			
			if (map.containsKey(sChar)) {
				if (map.get(sChar) != tChar) {
					return false;
				}
			}
			else {
				if (set.contains(tChar)) {
					return false;
				}
				map.put(sChar, tChar);
				set.add(tChar);
			}
		}
		return true;
	}
}