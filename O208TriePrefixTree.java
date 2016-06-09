public class O208TriePrefixTree {
	

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
	
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
	private TrieNode root;
	public O208TriePrefixTree() {
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
	
	
	public static void main(String[] args) {
		O208TriePrefixTree e = new O208TriePrefixTree();
		e.insert("a");
	}
}