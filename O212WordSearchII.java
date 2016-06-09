import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class O212WordSearchII {
	class TrieNode {
		public final static int R = 26;
		char val;
		TrieNode[] children;
		boolean isEndOfWord;
		public TrieNode(char c) {
			val = c;
			children = new TrieNode[R];
		}
		public TrieNode() {
			children = new TrieNode[R];
		}
	}
	class Trie {
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			int idxWord = 0;
			TrieNode item = root;
			while(idxWord != word.length()) {
				char c = word.charAt(idxWord);
				if (item.children[c - 'a'] == null) {
					item.children[c - 'a'] = new TrieNode(c);
				}
				item = item.children[c - 'a'];
				idxWord++;
			}
			item.isEndOfWord = true;
		}
		
		public boolean search(String word) {
			int idxWord = 0;
			TrieNode item = root;
			while(idxWord != word.length()) {
				char c = word.charAt(idxWord);
				if (item.children[c - 'a'] == null) {
					return false;
				}
				item = item.children[c - 'a'];
				idxWord++;
			}
			if (item.isEndOfWord) {
				return true;
			}
			else {
				return false;
			}
		}
		public boolean startsWith(String prefix) {
			int idxWord = 0;
			TrieNode item = root;
			while(idxWord != prefix.length()) {
				char c = prefix.charAt(idxWord);
				if (item.children[c - 'a'] == null) {
					return false;
				}
				item = item.children[c - 'a'];
				idxWord++;
			}
			return true;
		}
	}
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<>();
		if (board == null || board.length == 0 || board[0].length == 0)
			new ArrayList<>(res);
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, trie, isVisited, new StringBuilder(), res, i, j);
			}
		}
		return new ArrayList<>(res);
	}
	
	private void dfs(char[][] board, Trie trie, boolean[][] isVisited, StringBuilder singleRes, Set<String> res, int x, int y) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || isVisited[x][y]) {
			return;
		}
		singleRes.append(board[x][y]);
		String temp = singleRes.toString();
		isVisited[x][y] = true;
		if (trie.startsWith(temp)) {
			if (trie.search(temp)) {
				res.add(temp);
			}
			dfs(board, trie, isVisited, singleRes, res, x - 1, y);
			dfs(board, trie, isVisited, singleRes, res, x + 1, y);
			dfs(board, trie, isVisited, singleRes, res, x, y - 1);
			dfs(board, trie, isVisited, singleRes, res, x, y + 1);
		}
		isVisited[x][y] = false;
		singleRes.deleteCharAt(singleRes.length() - 1);
	}
}