public class O151ReverseWordsString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) return s;
		String[] sArray = s.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (int i = sArray.length - 1; i >= 0; i--) {
			if (!sArray[i].isEmpty()) {
				sb.append(sArray[i] + " ");
			}
		}
		return sb.toString().trim();
	}
}