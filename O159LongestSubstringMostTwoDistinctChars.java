import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class O159LongestSubstringMostTwoDistinctChars {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) return 0;
		int begin = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();
		int res = 0;
		
		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c) || (!map.containsKey(c) && map.size() < 2)) {
				map.put(c, end);
			}
			else {
				int minIdx = Integer.MAX_VALUE;
				for (char del : map.keySet()) {
					minIdx = Math.min(minIdx, map.get(del));
				}
				for (char del: map.keySet()) {
					if (minIdx == map.get(del)) {
						map.remove(del);
						begin = minIdx + 1;
						break;
					}
				}
			}
			res = Math.max(end - begin + 1, res);
			end++;
		}
		return res;
	}
	public static void main(String[] args) {
		O159LongestSubstringMostTwoDistinctChars e = new O159LongestSubstringMostTwoDistinctChars();
		System.out.println(e.lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}