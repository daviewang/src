import java.util.HashMap;
import java.util.Map;

public class O340LongestSubstringAtMostKDistinctChars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int res = 0;
		if (s == null || s.length() == 0) {
			return res;
		}
		Map<Character, Integer> map = new HashMap<>();
		int idx = 0;
		int start = 0;
		
		while (idx < s.length()) {
			char c = s.charAt(idx);
			map.put(c, idx++);
			if (map.size() > k) {
				int leftMost = s.length();
				for (Integer value : map.values()) {
					leftMost = Math.min(leftMost, value);
				}
				start = leftMost + 1;
				char removeChar = s.charAt(leftMost);
				map.remove(removeChar);
			}
			res = Math.max(res, idx - start);
		}
		return res;
		/*
		int res = 0;
		if (s == null || s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			queue.add(c);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
				while (map.size() > k) {
					char startChar = queue.poll();
					int count = map.get(startChar);
					if (count > 1) {
						map.put(startChar, count - 1);
					}
					else {
						map.remove(startChar);
					}
				}
			}
			res = Math.max(res, queue.size());
		}
		return res;
		*/
	}
	public static void main(String[] args) {
		O340LongestSubstringAtMostKDistinctChars e = new O340LongestSubstringAtMostKDistinctChars();
		System.out.println(e.lengthOfLongestSubstringKDistinct("AABABBA", 2));
	}
}