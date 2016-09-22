import java.util.*;

public class O387FirstUniqueCharacterInStr {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
    }
    
    public static void main(String[] args) {
    	O387FirstUniqueCharacterInStr e = new O387FirstUniqueCharacterInStr();
    	e.firstUniqChar("leetcode");
    }
}