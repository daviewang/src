public class O243ShortestWordDistanceI {
	public int shortestDistance(String[] words, String word1, String word2) {
		int idx1 = Integer.MAX_VALUE;
		int idx2 = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				idx1 = i;
			}
			if (words[i].equals(word2)) {
				idx2 = i;
			}
			
			if (idx1 != Integer.MAX_VALUE && idx2 != Integer.MAX_VALUE) {
				res = Math.min(res, Math.abs(idx1 - idx2));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O243ShortestWordDistanceI e = new O243ShortestWordDistanceI();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(e.shortestDistance(words, "coding", "practice"));
	}
}