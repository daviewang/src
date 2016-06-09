import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class O127WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> visited = new HashSet<>();
		Set<String> unVisited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		
		if (beginWord.equals(endWord)) {
			return 2;
		}
		
		queue.offer(beginWord);
		unVisited.addAll(wordList);
		unVisited.remove(beginWord);
		unVisited.add(endWord);
		
		int curr = 1;
		int next = 0;
		int res = 1;
		boolean found = false;
		
		while (!queue.isEmpty()) {
			curr--;
			String word = queue.poll();
			for (int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				for (char c = 'a'; c <= 'z'; c++) {
					sb.setCharAt(i, c);
					String newWord = sb.toString();
					if (unVisited.contains(newWord)) {
						if (visited.add(newWord)) {
							next++;
							queue.add(newWord);
						}
					}
					if (newWord.equals(endWord) && !found) {
						found = true;
					}
				}
			}
			if (curr == 0) {
				res++;
				if (found) {
					return res;
				}
				else {
					curr = next;
					next = 0;
					unVisited.removeAll(visited);
					visited.clear();
				}
			}
		}
		return 0;
	}
}