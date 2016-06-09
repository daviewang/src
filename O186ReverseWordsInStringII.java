public class O186ReverseWordsInStringII {
	public void reverseWords(char[] words) {
		if (words == null || words.length == 0) return;
		reverse(words, 0, words.length - 1);
		for (int begin = 0, end = 0; end <= words.length; end++) {
			if (words[end] == ' ' || end == words.length) {
				reverse(words, begin, end - 1);
				begin = end + 1;
			}
		}
	}
	
	public void reverse(char[] words, int start, int end) {
		while (start < end) {
			char c = words[start];
			words[start] = words[end];
			words[end] = c;
			start++;
			end--;
		}
	}
}