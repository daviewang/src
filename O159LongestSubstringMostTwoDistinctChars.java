import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class O159LongestSubstringMostTwoDistinctChars {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.size() == 2 && !map.containsKey(c)) {
				Iterator<Character> it = map.keySet().iterator();
				char[] keys = new char[2];
				int idx = 0;
				while (it.hasNext()) {
					keys[idx++] = it.next();
				}
				char delChar = map.get(keys[0]) > map.get(keys[1]) ? keys[1] : keys[0];
				start = map.get(delChar) + 1;
				map.remove(delChar);
			}
			/*
			if (map.size() == 2 && !map.containsKey(c)) {
				int mostLeftIdx = Integer.MAX_VALUE;
				int charToDel = ' ';
				for (char temp : map.keySet()) {
					if (map.get(temp) < mostLeftIdx) {
						mostLeftIdx = map.get(temp);
						charToDel = temp;
					}
				}
				map.remove(charToDel);
				start = mostLeftIdx + 1;
			}
			*/
			map.put(c, i);
			res = Math.max(res, i - start + 1);
		}
		return res;
	}
	public static void main(String[] args) {
		O159LongestSubstringMostTwoDistinctChars e = new O159LongestSubstringMostTwoDistinctChars();
		System.out.println(e.lengthOfLongestSubstringTwoDistinct("eceeebbba"));
	}
}