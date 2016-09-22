import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class O340LongestSubstringAtMostKDistinctChars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() < k) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0; 
		int end = 0;
		int res = 0;
		
		while (end < s.length()) {
			if (map.size() <= k) {
				char c = s.charAt(end);
				map.put(c, end);
				end++;
			}
			if (map.size() > k) {
				int leftMost = s.length();
				for (int i : map.values()) {
					leftMost = Math.min(leftMost, i);
				}
				char c = s.charAt(leftMost);
				map.remove(c);
				start = leftMost + 1;
			}
			res = Math.max(res, end - start);
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
		System.out.println(e.lengthOfLongestSubstringKDistinct("eceba", 2));
	}
}