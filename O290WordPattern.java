import java.util.HashMap;
import java.util.Map;

public class O290WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null)
			return false;
		String[] words = str.split(" ");
		if (pattern.length() != words.length)
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (!map.containsKey(c) && !map.containsValue(words[i])) {
				map.put(c, words[i]);
			}
			else if (!map.containsKey(c) && map.containsValue(words[i])) {
				return false;
			}
			else if (!map.get(c).equals(words[i])) {
				return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		O290WordPattern e = new O290WordPattern();
		e.wordPattern("abba", "dog dog dog dog");
	}
}