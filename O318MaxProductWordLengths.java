public class O318MaxProductWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int[] wordBit = new int[words.length];
		
		for (int i = 0; i < words.length; i++) {
			int singleWordBit = 0;
			for (int j = 0; j < words[i].length(); j++) {
				singleWordBit |= 1 << (words[i].charAt(j) - 'a');
			}
			wordBit[i] = singleWordBit;
		}
		
		int res = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((wordBit[i] & wordBit[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O318MaxProductWordLengths e = new O318MaxProductWordLengths();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		e.maxProduct(words);
	}
}