import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class O269AlienDictionary {
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) return "";
		
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		
		for (String word : words) {
			for (Character c : word.toCharArray()) {
				degree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			
			int len = Math.min(word1.length(), word2.length());
			
			for (int j = 0; j < len; j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);
				if (c1 != c2) {
					if (map.containsKey(c1)) {
						Set<Character> set = map.get(c1);
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2) + 1);
					}
					else {
						Set<Character> set = new HashSet<>();
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, 1);
					}
					break;
				}
			}
		}
			
		Queue<Character> queue = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0) {
				queue.add(c);
			}
		}
		
		while (!queue.isEmpty()) {
			char singleRes = queue.poll();
			res.append(singleRes);
			if (map.containsKey(singleRes)) {
				Set<Character> set = map.get(singleRes);
				for (char c : set) {
					degree.put(c, degree.get(c) - 1);
					if (degree.get(c) == 0) {
						queue.offer(c);
					}
				}
			}
		}
		
		return res.toString();		
	}
	
	public static void main(String[] args) {
		String [] in = {  "wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"};
		O269AlienDictionary e = new O269AlienDictionary();
		System.out.println(e.alienOrder(in));		
	}
}