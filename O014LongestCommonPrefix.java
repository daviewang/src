public class O014LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		String primeStr = strs[0];
		for (int i = 0; i < primeStr.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() < i + 1 || primeStr.charAt(i) != strs[j].charAt(i)) {
					return primeStr.substring(0, i);
				}
			}
		}
		return primeStr;
	}
	public static void main(String[] args) {
		O014LongestCommonPrefix e = new O014LongestCommonPrefix();
		String[] strs = {"aabb", "aa"};
		e.longestCommonPrefix(strs);
	}
}