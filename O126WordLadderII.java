import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class O126WordLadderII {
	List<List<String>> res = new ArrayList<>();
	List<String> singleRes = new ArrayList<>();
	Map<String, List<String>> ladder = new HashMap<>();
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		int curr = 1;
		int next = 0;
		boolean found = false;
		Set<String> unvisited = new HashSet<>(dict);
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		
		queue.offer(start);
		unvisited.add(end);
		unvisited.remove(start);
		
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			curr--;
			
			for (int i = 0; i < vertex.length(); i++) {
				StringBuilder sb = new StringBuilder(vertex);
				for (char c = 'a'; c <= 'z'; c++) {
					sb.setCharAt(i, c);
					String newWord = sb.toString();
					if (unvisited.contains(newWord)) {
						if (visited.add(newWord)) {
							next++;
							queue.offer(newWord);
						}
						if (ladder.containsKey(newWord)) {
							ladder.get(newWord).add(vertex);
						}
						else {
							List<String> list = new ArrayList<>();
							list.add(vertex);
							ladder.put(newWord, list);
						}
					}
					if (newWord.equals(end) && !found) {
						found = true;
					}
				}
			}
			if (curr == 0) {
				if (found) {
					break;
				}
				curr = next;
				next = 0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}
		backTrace(end, start);
		return res;
	}
	
	private void backTrace(String word, String start) {
		if (word.equals(start)) {
			singleRes.add(0, word);
			res.add(new ArrayList<>(singleRes));
			singleRes.remove(0);
			return;
		}
		singleRes.add(0, word);
		if (ladder.get(word) != null) {
			for (String s : ladder.get(word)) {
				backTrace(s, start);
			}
		}
		singleRes.remove(0);
	}
}