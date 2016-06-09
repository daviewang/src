import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class O291WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return isMatch(pattern, 0, str, 0, map, set);
	}
	
	private boolean isMatch(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
		if (i == pattern.length() && j == str.length()) {
			return true;
		}
		if (i == pattern.length() || j == str.length()) {
			return false;
		}
		
		char p = pattern.charAt(i);
		
		if (map.containsKey(p)) {
			String s = map.get(p);
			if (str.startsWith(s, j)) {
				return isMatch(pattern, i + 1, str, j + s.length(), map, set);
			}
			else {
				return false;
			}
		}
		
		for (int k = j; k < str.length(); k++) {
			String s = str.substring(j, k + 1);
			
			if (set.contains(s)) {
				continue;
			}
			
			map.put(p, s);
			set.add(s);
			
			if (isMatch(pattern, i + 1, str, k + 1, map, set)) {
				return true;
			}
			else {
				map.remove(p, s);
				set.remove(s);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		O291WordPatternII e = new O291WordPatternII();
		System.out.println(e.wordPatternMatch("ababa", "redblueredbluered"));
	}
}