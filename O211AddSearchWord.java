public class O211AddSearchWord {
	private static final int R = 26;
	class TrieNode {
		char c;
		TrieNode[] children = new TrieNode[R];
		boolean isEndOfWord;
		
		public TrieNode(){};
		public TrieNode(char c) {
			this.c = c;
			isEndOfWord = false;
		}
	}
	
	private TrieNode root = new TrieNode();
	
	public void addWord(String word) {
		TrieNode item = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (item.children[c - 'a'] == null) {
				item.children[c - 'a'] = new TrieNode(c);
			}
			item = item.children[c - 'a'];
		}
		item.isEndOfWord = true;
	}
	
	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}
	
	private boolean search(char[] word, int idx, TrieNode node) {
		if (idx == word.length) {
			if (node.isEndOfWord) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if (word[idx] == '.') {
			for (int j = 0; j < R; j++) {
				if (node.children[j] != null) {
					if (search(word, idx + 1, node.children[j]))
						return true;
				}
			}
			return false;
		}
		
		if (node.children[word[idx] - 'a'] == null)
			return false;
		node = node.children[word[idx] - 'a'];
		return search(word, idx + 1, node);
	}
}