public class O058LengthLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ' ') {
				if (res != 0) break;
			}
			else {
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		O058LengthLastWord e = new O058LengthLastWord();
		System.out.println(e.lengthOfLastWord("a "));
	}
}