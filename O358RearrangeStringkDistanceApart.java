import java.util.*;

public class O358RearrangeStringkDistanceApart {
	public String rearrangeString(String str, int k) {
		if (str == null || str.length() == 0 || k == 0) {
			return str;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		Comparator<Map.Entry<Character, Integer>> cp = new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
				return b.getValue() - a.getValue();
			}
		};
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(10, cp);
		pq.addAll(map.entrySet());
		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			sb.append(entry.getKey());
			entry.setValue(entry.getValue() - 1);
			waitQueue.offer(entry);
			
			if (waitQueue.size() >= k) {
				Map.Entry<Character, Integer> waitEntry = waitQueue.poll();
				if (waitEntry.getValue() != 0) {
					pq.offer(waitEntry);
				}
			}
		}
		if (sb.length() != str.length()) {
			return "";
		}
		else {
			return sb.toString();
		}
	}
	public static void main(String[] args) {
		O358RearrangeStringkDistanceApart e = new O358RearrangeStringkDistanceApart();
		e.rearrangeString("aaabc", 3);
	}
}