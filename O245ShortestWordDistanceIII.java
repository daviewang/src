public class O245ShortestWordDistanceIII {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) return 0;
		boolean same = word1.equals(word2);
		int res = Integer.MAX_VALUE;
		int idx1 = Integer.MAX_VALUE;
		int idx2 = Integer.MAX_VALUE;
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word1.equals(word)) {
				if (same) {
					idx1 = idx2;
				}
				else {
					idx1 = i;
				}
			}
			if (word2.equals(word)) {
				idx2 = i;
			}
			if (idx1 != Integer.MAX_VALUE && idx2 != Integer.MAX_VALUE) {
				res = Math.min(res, Math.abs(idx2 - idx1));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		O245ShortestWordDistanceIII e = new O245ShortestWordDistanceIII();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(e.shortestDistance(words, "makes", "makes"));
	}
}